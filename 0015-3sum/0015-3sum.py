class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        res = []
        nums.sort()
        for i in range(n):
            first = nums[i]
            if first > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            left = i+1
            right = n-1
            while left<right:
                sum = first + nums[left] + nums[right]
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while nums[left] == nums[left-1] and left < right:
                        left += 1
        return res
