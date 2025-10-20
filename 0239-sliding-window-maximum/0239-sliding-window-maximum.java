class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || k<=0) return new int[0];
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            int left = i-k+1;
            if(dq.peekFirst()<left){
                dq.pollFirst();
            }

            if(left>=0){
                ans[left]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}