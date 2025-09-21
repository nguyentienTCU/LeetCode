class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainerCount = new int[60];
        int res = 0;

        for (int t : time) {
            int remainer = t % 60;
            int need = (60 - remainer) % 60;
            res += remainerCount[need];
            remainerCount[remainer]++;
        }
        return res;
    }
}
