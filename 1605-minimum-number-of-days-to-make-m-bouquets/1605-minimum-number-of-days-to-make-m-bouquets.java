class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)n<(long)m*k) return -1;
        int left = findMin(bloomDay);
        int right = findMax(bloomDay);
        int ans = 0;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(checkAdjacent(bloomDay, m, k, mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    private int findMin(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(arr[i], min);
        }
        return min;
    }

    private int findMax(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }

    private boolean checkAdjacent(int[] arr, int m, int k, int day){
        int bouquets = 0;
        int flower = 0;

        for (int x : arr) {
            if (x <= day) {
                flower++;
                if (flower == k) {
                    bouquets++;
                    if (bouquets >= m) return true;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return bouquets >= m;
    }
}