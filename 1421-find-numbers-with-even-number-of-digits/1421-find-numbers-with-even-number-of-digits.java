class Solution {
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for(int i=0;i<nums.length;i++){
            int countDigit = 0;

            if(nums[i]==0){
                countDigit = 1;
            }
            int cur = nums[i];
            while(cur>0){
                countDigit++;
                cur = cur/10;
            }

            if(countDigit%2==0){
                countEven++;
            }
        } return countEven;
    }
}