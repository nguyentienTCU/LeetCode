class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) map.put(x, map.getOrDefault(x, 0)+1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for(int num : list){
            int numCount = map.get(num);
            if(numCount==0) continue;

            int need = 2*num;
            int needCount = map.getOrDefault(need, 0);
            if(numCount > needCount) return false;

            map.put(need, needCount-numCount);
        }
        return true;
    }
}