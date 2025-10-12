class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MODULO = 1_000_000_007L;
        
        long[] prefixSum = new long[n+1];
        for(int i=0; i<n; i++) prefixSum[i+1]=prefixSum[i]+nums[i];

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long max=0;

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