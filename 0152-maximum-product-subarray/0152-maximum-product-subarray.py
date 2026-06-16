class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        curMin = 1
        curMax = 1
        for num in nums:
            tmp = curMin
            curMin = min(num, curMax * num, curMin * num)
            curMax = max(num, curMax * num, tmp * num)
            res = max(res, curMax)
        return res