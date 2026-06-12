class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        def houseRob(nums):
            n = len(nums)
            if n == 0:
                return 0

            if n == 1:
                return nums[0]

            prev = nums[0]
            cur = max(nums[0],nums[1])
            for i in range(2, n):
                tmp = cur
                cur = max(cur, prev + nums[i])
                prev = tmp

            return cur

        return max(houseRob(nums[1:]), houseRob(nums[:-1]))
