class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       //map: key -> element in the array , value -> the frequency of that element
       for(int i=0; i<nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
       } 

        //buckets: index -> the frequency , value -> a list of all elements having that frequency
       List<Integer>[] buckets = new ArrayList[nums.length+1];
       for(int x : map.keySet()){
        if(buckets[map.get(x)]==null){
            buckets[map.get(x)] = new ArrayList<>();
        }
        buckets[map.get(x)].add(x);
       }

        int count = k;
        int[] ans = new int[k];
        int idx=0;
       for(int i=nums.length; i>=1; i--){
            if(buckets[i]==null) continue;
            for(int j=0; j<buckets[i].size(); j++){
                count--;
                if(count<0) return ans;;
                ans[idx] = buckets[i].get(j);
                idx++;
            }
       }
       
       return ans;
    }
}