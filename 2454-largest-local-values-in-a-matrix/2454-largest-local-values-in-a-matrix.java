class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length - 2;
        int[][] res = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int max=0;
                for(int k=i; k<i+3; k++){
                    for(int p=j; p<j+3; p++){
                        max = Math.max(max, grid[k][p]);
                    }
                }
                res[i][j]=max;
            }
        }
        return res;
    }
}