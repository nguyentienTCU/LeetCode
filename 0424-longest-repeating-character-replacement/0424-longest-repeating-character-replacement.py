class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # initialize a window with left and right boundaries, expand the right boundary 
        # inside the window, I want to know the frequency of the most frequent character
        # use a map to store the character and their corresponding frequencies
        # use a variable to store (record and update) the highest frequency
        # get the needed number of replacement (size of window - highest frequency)
        # if that number is larger than k, then we shrink the window

        left = 0
        map = {}
        maxFreq = 0
        res = 0

        for right in range(len(s)):
            map[s[right]] = map.get(s[right],0) + 1
            maxFreq = max(maxFreq,map[s[right]])

            while (right - left + 1) - maxFreq > k:
                map[s[left]] -= 1
                left += 1
            res = max(res, right-left+1)
        return res
            