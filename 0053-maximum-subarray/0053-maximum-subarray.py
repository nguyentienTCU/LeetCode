class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # -2 1 -3 4 -1 2 1 -5 4
        # -2 1 -3 0 -> 
        # curSum = 0
        # maxSum = 1
        curSum = 0
        maxSum = nums[0]
        for num in nums:
            curSum += num
            maxSum = max(maxSum, curSum)
            if curSum < 0:
                curSum = 0
        return maxSum