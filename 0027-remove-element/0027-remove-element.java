class Solution {
    public int removeElement(int[] nums, int val) {
     int i = 0;
     int j = nums.length-1;
     while(i<nums.length){
        if(nums[i]==val){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j--;
            i--;
        }
        if(i==j){
            return i+1;
        }
        i++;
     } return 0;
    }
}   
