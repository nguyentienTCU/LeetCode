class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, false, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int i, boolean duplicateChecked, List<Integer> path, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        backtrack(nums, i+1, false, path, res);
        if(i==0 || nums[i]!=nums[i-1] || duplicateChecked){
            path.add(nums[i]);
            backtrack(nums, i+1, true, path, res);
            path.remove(path.size()-1);
        };
    }
}