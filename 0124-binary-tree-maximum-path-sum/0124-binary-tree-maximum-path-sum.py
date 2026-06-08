# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # best path = the largest sum taken by adding the values of all nodes in that path
        # initialize a variable res to record the answer
        # for each node, find the "best path" starting from that node, then update res
        # to find the "best path" starting from node A, find the max downward path to the left of A and to the right of A -> best path = maxDownward(A.left) + maxDownward(A.right) + A.val
        # to find the max downward path of a node, find the max downward path to the left and to the right and take the larger value -> maxDownward(B) = B.val + max(maxDownward(B.left),maxDownward(B.right))

        res = root.val
        def dfs(node):
            nonlocal res
            if not node:
                return 0
            leftMax = dfs(node.left)
            rightMax = dfs(node.right)
            leftMax = max(0,leftMax)
            rightMax = max(0,rightMax)
            res = max(res, node.val + leftMax + rightMax)
            return node.val + max(leftMax, rightMax)

        dfs(root)
        return res
