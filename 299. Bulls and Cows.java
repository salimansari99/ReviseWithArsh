class Solution {
    public String getHint(String secret, String guess) {
        
        int n = secret.length();
        int bulls = 0;
        for(int i = 0; i < n; i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2) bulls++;
        }
        StringBuilder res = new StringBuilder();
        if(bulls == n) {
            res.append(n).append("A").append(0).append("B");
            return res.toString();
        }
        
        char[] a1 = secret.toCharArray();
        char[] a2 = guess.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        int cows = 0;
        int i = 0, j = 0;
        
        while(i < n && j < n) {
            if(a1[i] == a2[j]) {
                cows++;
                i++;
                j++;
            }
            else if(a1[i] < a2[j]) i++;
            else j++;
        }
        
        cows = cows-bulls;
        
        res.append(bulls).append("A").append(cows).append("B");
        return res.toString();
    }
}