class Solution {
    public int arrangeCoins(int n) {
      long left = 0;
      long right = n;
      long ans = 0;
      while(left<=right){
        long mid = left + (right-left)/2;
        long sum = mid*(mid+1)/2;
        if(sum<=n){
            ans = mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
      }
      return (int)ans; 
    }
}