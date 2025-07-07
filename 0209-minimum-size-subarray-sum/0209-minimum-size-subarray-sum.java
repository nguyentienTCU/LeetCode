class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLength = 0;
        int sum = 0;
        for(int right=0; right<nums.length; right++){
            sum+=nums[right];

            while(sum>=target){
                minLength = minLength == 0 ? right-left+1 : Math.min(minLength, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minLength;
    }
}