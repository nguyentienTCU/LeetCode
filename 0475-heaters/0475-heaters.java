class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        long ans=0;

        for(int house : houses){
            int idx = lowerBound(house, heaters);   //index of the first element >= house in the array heaters
            long best = Long.MAX_VALUE;

            //find the shortest distance from the current house to a heater
            if(idx<heaters.length){
                best = Math.min(best, Math.abs((long)heaters[idx]-house));  //right heater
            }
            if(idx>=1){
                best = Math.min(best, Math.abs((long)house-heaters[idx-1]));    //left heater
            }

            //find the needed radius (longest distance)
            ans = Math.max(ans, best);
        }
        return (int) ans;
    }


    //lowerBound: this method returns the leftmost index of the element in the array nums that is larger than target
    private int lowerBound(int target, int[] nums){
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}