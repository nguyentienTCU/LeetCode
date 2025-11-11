class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";

        String[] arr = new String[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i]+"";
        }

        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";

        String ans = "";
        for(String s : arr){
            ans+=s;
        }
        return ans;
    }
}