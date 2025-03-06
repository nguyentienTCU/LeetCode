class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int left = 1;
       int right = 1;
       int max = nums[0];
       for(int i=0; i<nums.length; i++){
            if(left==0){
                left=1;
            }
            if(right==0){
                right=1;
            }
            left*=nums[i];
            right*=nums[n-1-i];
            max = Math.max(Math.max(left, right),max);
       }return max;
    }
}