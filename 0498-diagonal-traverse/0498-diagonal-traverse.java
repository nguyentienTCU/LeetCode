class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];

        int r = 0, c = 0, dir = 1; // 1: up-right, -1: down-left
        for (int k = 0; k < m * n; k++) {
            res[k] = mat[r][c];
            if (dir == 1) { // up-right
                if (c == n - 1) { r++; dir = -1; }      // right wall → go down
                else if (r == 0) { c++; dir = -1; }     // top wall → go right
                else { r--; c++; }                      // normal step
            } else { // dir == -1, down-left
                if (r == m - 1) { c++; dir = 1; }       // bottom wall → go right
                else if (c == 0) { r++; dir = 1; }      // left wall → go down
                else { r++; c--; }                      // normal step
            }
        }
        return res;
    }
}
