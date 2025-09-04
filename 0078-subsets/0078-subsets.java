class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int i, int[] nums, List<Integer> path, List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //skip adding element
        backtrack(i+1, nums, path, res);

        //adding element
        path.add(nums[i]);
        backtrack(i+1, nums, path, res);
        path.remove(path.size()-1);
    }
}