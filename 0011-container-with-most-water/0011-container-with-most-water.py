class Solution:
    def maxArea(self, height: List[int]) -> int:
        # Area = 7 x 7 = max((right-left) x min(height[right],height[left]))
        largest = 0
        left = 0
        right = len(height)-1
        while left<right:
            area = (right - left) * min(height[left], height[right])
            largest = max(largest, area)
            if height[left]<height[right]:
                left += 1
            else:
                right -= 1
        return largest
