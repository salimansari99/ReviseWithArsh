class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) arr[i] = i+1;
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] vis = new boolean[9];
        subset(arr, 0, k, n, vis, ds, res);
        return res;
    }
    public static void subset(int[] arr, int ind, int k, int target, boolean[] vis, List<Integer> ds, List<List<Integer>> res) {
        if(target < 0) return;
        else if(target == 0) {
            if(ds.size() == k) res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = ind; i < arr.length; i++) {
            if(vis[i] == false) {
                vis[i] = true;
                ds.add(arr[i]);
                subset(arr, i+1, k, target-arr[i], vis, ds, res);
                ds.remove(ds.size()-1);
                vis[i] = false;
            }
        }
    }
}