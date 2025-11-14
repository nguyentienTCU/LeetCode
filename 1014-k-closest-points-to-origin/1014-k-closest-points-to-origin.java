class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length-1, k);
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }

    private void quickSelect(int[][] nums, int start, int end, int k){
        if(start==end) return;
        int val = nums[end][0]*nums[end][0]+nums[end][1]*nums[end][1];
        int cur = start;
        for(int i=start; i<end; i++){
            int curVal = nums[i][0]*nums[i][0]+nums[i][1]*nums[i][1];
            if(curVal<val){
                swap(nums, i, cur);
                cur++;
            }
        }
        swap(nums, cur, end);
        if(cur==k-1){
            return;
        }else if(k-1<cur){
            quickSelect(nums, start, cur-1, k);
        }else{
            quickSelect(nums, cur+1, end, k);
        }
    }

    private void swap(int[][] nums, int i, int j){
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}