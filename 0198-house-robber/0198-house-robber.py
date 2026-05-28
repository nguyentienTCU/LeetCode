class Solution:
    def rob(self, nums: List[int]) -> int:
        # dp[i] will store the largest amount of money that can be robbed at that stage
        # return dp[n] where n = len(nums)
        if len(nums) == 1:
            return nums[0]
        n = len(nums)

        prevMax = nums[0]
        curMax = max(nums[1], nums[0])
                
        for i in range(2, n):
            tmp = curMax
            curMax = max(curMax, prevMax + nums[i])
            prevMax = tmp
        
        return curMax