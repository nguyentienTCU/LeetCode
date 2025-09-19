class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int right=n-1;
        int left=0;

        while(left<right){
            int top = left;
            int bottom = right;
        for(int i=0; i<right - left; i++){
            int tmp = matrix[top][left+i]; //save top left
            matrix[top][left+i] = matrix[bottom-i][left];
            matrix[bottom-i][left] = matrix[bottom][right-i];
            matrix[bottom][right-i] = matrix[top+i][right];
            matrix[top+i][right] = tmp;
        }
        left++;
        right--;
        }
    }
}