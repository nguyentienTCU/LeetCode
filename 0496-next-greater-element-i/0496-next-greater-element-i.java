class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();    //value -> rightmost greater value
        Stack<Integer> st = new Stack<>();

        for(int x:nums2){
            while(!st.isEmpty() && x>st.peek()){
                map.put(st.pop(), x);
            }
            st.push(x);
        }

        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}