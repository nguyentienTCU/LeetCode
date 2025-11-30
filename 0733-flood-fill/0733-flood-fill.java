class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image, sr, sc, color, oldColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int oldColor){
        int rows = image.length;
        int cols = image[0].length;

        if(r<0 || r>=rows || c<0 || c>=cols || image[r][c] != oldColor) return;

        image[r][c] = color;

        dfs(image, r, c-1, color, oldColor);
        dfs(image, r, c+1, color, oldColor);
        dfs(image, r-1, c, color, oldColor);
        dfs(image, r+1, c, color, oldColor);
    }
}