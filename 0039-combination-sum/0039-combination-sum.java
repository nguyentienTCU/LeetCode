class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, 0, candidates, target, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int start, int[] nums, int remain, List<Integer> path){
        if(remain==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(nums[i]>remain) break;

            path.add(nums[i]);
            backtrack(res, i, nums, remain-nums[i], path);
            path.remove(path.size()-1);
        }
    }
}