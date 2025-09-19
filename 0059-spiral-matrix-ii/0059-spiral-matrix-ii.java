class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // left -> right
            for (int c = left; c <= right; c++) a[top][c] = num++;
            top++;

            // top -> bottom
            for (int r = top; r <= bottom; r++) a[r][right] = num++;
            right--;

            // right -> left (only if still a row left)
            if (top <= bottom) {
                for (int c = right; c >= left; c--) a[bottom][c] = num++;
                bottom--;
            }

            // bottom -> top (only if still a col left)
            if (left <= right) {
                for (int r = bottom; r >= top; r--) a[r][left] = num++;
                left++;
            }
        }
        return a;
    }
}
