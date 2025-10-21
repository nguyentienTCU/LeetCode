class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int start, int remain, List<Integer> path){
        if(remain==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            if(nums[i]>remain) break;

            path.add(nums[i]);
            backtrack(res, nums, i+1, remain-nums[i], path);
            path.remove(path.size()-1);
        }
    }
}