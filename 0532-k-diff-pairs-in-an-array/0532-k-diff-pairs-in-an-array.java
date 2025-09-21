class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        int ans = 0;
        if(k==0){
            Map<Integer, Integer> map = new HashMap<>();
            for(int num:nums) map.put(num, map.getOrDefault(num,0)+1);

            for(int x:map.values()){
                if(x>=2) ans++;
            }
        }else{
            Set<Integer> set = new HashSet<>();
            for(int num:nums) set.add(num);

            for(int x:set){
                if(set.contains(x+k)) ans++;
            }
        }
        return ans;
    }
}