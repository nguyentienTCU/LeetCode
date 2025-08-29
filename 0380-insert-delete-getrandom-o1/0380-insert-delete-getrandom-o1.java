class RandomizedSet {

    private List<Integer> arr;
    private Map<Integer, Integer> pos;  // (key,val) = (val, idx)
    private Random rand;

    public RandomizedSet() {
        arr = new ArrayList<>();
        pos = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(pos.containsKey(val)) return false;
        pos.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!pos.containsKey(val)) return false;
        int idx = pos.get(val);

        int lastVal = arr.get(arr.size()-1);

        arr.set(idx, lastVal);
        pos.put(lastVal, idx);

        arr.remove(arr.size()-1);
        pos.remove(val);
        return true;
    }
    
    public int getRandom() {
        int i = rand.nextInt(arr.size());
        return arr.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */