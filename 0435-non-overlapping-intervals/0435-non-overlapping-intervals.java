class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];
        int curStart;
        int curEnd;

        for(int i=1; i<intervals.length; i++){
            curStart = intervals[i][0];
            curEnd = intervals[i][1];

            if(prevEnd > curStart){
                count++;
            }else{
                prevEnd = curEnd;
            }
        }
        return count;
    }
}