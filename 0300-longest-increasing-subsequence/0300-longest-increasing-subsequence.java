class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int num : nums){
            if(list.size()==0 || list.get(list.size()-1)<num){
                list.add(num);
            }else{
                //find the index of the leftmost element in the list that is >= nums[i]
                int idx = findIdx(list, num);
                list.set(idx, num);
            }
        }
        return list.size();
    }

    private int findIdx(List<Integer> list, int val){
            int left = 0;
            int right = list.size()-1;
            int ans = -1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(list.get(mid)>=val){
                    ans = mid;
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return ans;
        }
}