class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> pos = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]==x) pos.add(i);
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int q = queries[i];
            ans[i] = (q>=1 && q<=pos.size()) ? pos.get(q-1) : -1;
        }

        return ans;
    }
}