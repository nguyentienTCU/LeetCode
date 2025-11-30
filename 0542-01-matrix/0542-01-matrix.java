class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    queue.offer(new int[]{i,j});
                }else{
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] move : moves){
                int nr = r + move[0];
                int nc = c + move[1];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    if(ans[nr][nc] > ans[r][c]+1){
                        ans[nr][nc] = ans[r][c]+1;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return ans;
    }
}