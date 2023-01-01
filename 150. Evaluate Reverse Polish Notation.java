class Solution {
    public int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                int res = 0;
                if(s.equals("+")) {
                    res = a+b;
                }
                else if(s.equals("-")) {
                    res = b-a;
                }
                else if(s.equals("*")) {
                    res = a*b;
                }
                else if(s.equals("/")) {
                    res = b/a;
                }
                st.push(res);
            }
            else {
                int val = Integer.parseInt(s);
                st.push(val);
            }
        }
        return st.peek();
    }
}