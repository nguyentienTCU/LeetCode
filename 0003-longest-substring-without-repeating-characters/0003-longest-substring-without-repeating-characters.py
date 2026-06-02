class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1:
            return len(s)

        left = 0
        right = 0
        longest = 0
        check = set()
        while right<len(s):
            while s[right] in check:
                check.remove(s[left])
                left += 1

            check.add(s[right])
            longest = max(longest,right-left+1)
            right += 1
        return longest
            