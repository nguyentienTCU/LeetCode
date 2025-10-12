class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MODULO = 1_000_000_007L;
        
        //construct the prefix sum
        long[] prefixSum = new long[n+1];
        for(int i=0; i<n; i++) prefixSum[i+1]=prefixSum[i]+nums[i];

        //setup for monotonic increasing/decreasing stacks
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> st = new Stack<>();

        //strict increasing monotonic stack (pops equal sign)
        //find the nearest index that has smaller value on the left: (2,3,3,1,2) -> (-1,0,0,-1,3)
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        //non-strict increasing monotonic stack (does not pop equal sign)
        //find the nearest index that has smaller value on the right: (2,3,3,1,2) -> (3,2,3,5,5)
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long max=0;

        //for each element nums[i], find the largest range where nums[i] is the smallest value
        for(int i=0; i<n; i++){
            int l = left[i]+1;
            int r = right[i]-1;
            long sum = prefixSum[r+1] - prefixSum[l];
            long totalVal = sum*nums[i];
            if(totalVal>max) max=totalVal;
        }

        return (int) (max%MODULO);
    }
}