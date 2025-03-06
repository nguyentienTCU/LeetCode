class Solution {
    public int dominantIndex(int[] nums) {
        int secondHighest = 0;
        int highest = 0;
        int index=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]>secondHighest){
                if(nums[i]>highest){
                    secondHighest = highest;
                    highest = nums[i];
                }else{
                    secondHighest = nums[i];
                }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==highest){
                index = i;
            }
        }
        if(secondHighest<=(highest/2)){
            return index;
        }return -1;
    }
}