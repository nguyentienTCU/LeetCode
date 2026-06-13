class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        resLen = 0
        resIdx = 0
        for i in range(n):
            # the center has 1 char
            left = i
            right = i
            while left >= 0 and right < n and s[left] == s[right]:
                if (right - left + 1) > resLen:
                    resIdx = left
                    resLen = right - left + 1
                left -= 1
                right += 1

            # the center has 2 chars
            left = i
            right = i+1
            while left >= 0 and right < n and s[left] == s[right]:
                if (right - left + 1) > resLen:
                    resIdx = left
                    resLen = right - left + 1
                left -= 1
                right += 1
        return s[resIdx : resIdx + resLen]