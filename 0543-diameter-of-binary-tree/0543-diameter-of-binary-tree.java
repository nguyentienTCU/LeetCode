/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] c = calculate(root);
        return c[0]-1;
    }

    public int[] calculate(TreeNode root){
        if(root==null) return new int[]{0, 0};
        int[] left = calculate(root.left);
        int[] right = calculate(root.right);

        int max = Math.max(left[0], right[0]);
        max = Math.max(max, left[1]+right[1]+1);
        int height = Math.max(left[1], right[1])+1;

        return new int[]{max, height};
    }
}