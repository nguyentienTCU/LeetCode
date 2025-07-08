class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] next = intervals[i];
            if(cur[1]>=next[0]){
                cur[1] = Math.max(cur[1], next[1]);
            }else{
                merged.add(cur);
                cur = next;
            }
        }

        merged.add(cur);
        return merged.toArray(new int[merged.size()][]);
    }
}