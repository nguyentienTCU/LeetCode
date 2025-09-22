class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Integer> ballCount = new HashMap<>();              //(ball, color)
        Map<Integer, Integer> colorCount = new HashMap<>();             //(color, number of balls)
        int distinctColor = 0;

        for(int i=0; i<n; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            Integer oldColor = ballCount.get(ball);
            if(oldColor!=null && oldColor==color){      //same color
                ans[i] = distinctColor;
                continue;
            }

            if(oldColor!=null){         //remove old color
                int freq = colorCount.get(oldColor)-1;
                if(freq==0){
                    colorCount.remove(oldColor);
                    distinctColor--;
                }else{
                    colorCount.put(oldColor, freq);
                }
            }

            //add new color
            int before = colorCount.getOrDefault(color, 0);
            if(before==0) distinctColor++;
            colorCount.put(color, before+1);

            ballCount.put(ball, color);
            ans[i] = distinctColor;
        }

        return ans;
    }
}