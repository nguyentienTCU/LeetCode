class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0 || k>n) return res;
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> res){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        int need = k - path.size();      //how many more we must pick
        for(int i=start; i<=n-need+1; i++){
            path.add(i);
            backtrack(i+1, n, k, path, res);
            path.remove(path.size()-1);
        }
    }
}