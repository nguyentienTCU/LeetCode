class Solution {
    public int sumOfUnique(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        int i=0;
        int n= nums.length;

        while(i<n){
            int j=i+1;
            while(j<n && nums[j]==nums[i]) j++;
            if(j-i==1){
                sum+=nums[i];
            }
            i=j;
        }
        return sum;
    }
}