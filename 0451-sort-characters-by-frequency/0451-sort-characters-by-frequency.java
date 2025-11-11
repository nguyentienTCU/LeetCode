class Solution {
    public String frequencySort(String s) {
        //map: key = each character, value = the frequency of that character
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        //Buckets: index = frequency, value = list of chars with that freq
        List<Character>[] buckets = new ArrayList[s.length()+1];
        for(char c : map.keySet()){
            int freq = map.get(c);
            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        String ans = "";
        for(int i=s.length(); i>=1; i--){
            if(buckets[i]!=null){
            for(char c : buckets[i]){
                String d = c+"";
                ans+=d.repeat(i);
            }
        }
        }
        return ans;
    }
}