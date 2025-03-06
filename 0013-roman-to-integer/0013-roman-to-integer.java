class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int nBack = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        for (int i = s.length()-1; i >= 0; i--) {
            int n = map.get(s.charAt(i));
            if (n<nBack) {
                sum-=n;
            } else {
                sum+=n;
            }
            nBack = n;
        }
        return sum;
    } 
}