class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0

        n = len(height)
        res = 0

        left = 0
        right = n-1
        leftMax = height[0]
        rightMax = height[n-1]

        while left<right:
            if leftMax < rightMax:
                left += 1
                leftMax = max(leftMax, height[left])
                res += leftMax - height[left]
            else:
                right -= 1
                rightMax = max(rightMax, height[right])
                res += rightMax - height[right]
        return res