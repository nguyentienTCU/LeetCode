class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> list = new ArrayList<>();
       boolean[] exist = new boolean[nums.length+1];
       for(int i=0; i<nums.length; i++){
        exist[nums[i]]=true;
       }
       for(int i=1; i<=nums.length; i++){
        if(exist[i]==false){
            list.add(i);
        }
       } return list;
    }
}