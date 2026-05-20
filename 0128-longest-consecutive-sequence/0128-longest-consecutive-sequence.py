class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        check = set(nums)
        longest = 0
        for num in check:
            if (num-1) not in check:
                length = 1
                next = num+1
                while next in check:
                    length += 1
                    next += 1
                longest = max(longest, length)
        return longest
        

