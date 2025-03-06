class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0]=0;
        for(int i=1; i<prefixSum.length; i++){
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }

        for(int i=1; i<prefixSum.length;i++){
            if(prefixSum[i-1]==prefixSum[prefixSum.length-1]-prefixSum[i]){
                return i-1;
            }
        }return -1;
    }
}