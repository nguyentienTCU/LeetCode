class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        maxIndex = nums[0]
        for i in range(1,n):
            if maxIndex>=n-1:
                return True
            if i <= maxIndex:
                maxIndex = max(maxIndex, i+nums[i])
        return maxIndex>=n-1