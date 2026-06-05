class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # initialize a window with left and right boundaries
        # initialize a variable shortest to update the shortest length of the satisfied substring and res to update the indices of that shortest substring 
        # expand the right boundary until the window contains all chars in t
        # use a map to store the frequency of each char in t: {char -> freq}
        # use a map to store the frequency of each char in the window: {char -> freq}
        # use a variable to store the number of distinct character in t (so we can compare this to the window later)
        # check if a distinct char in t is also in the window and have the same frequency. If yes, use a variable to store the number of chars satisfying this
        # if 2 variables are equal, update res and shortest + shrink left boundary + remove it from the map + decrease the variable

        if t == "":
            return ""
        if len(s) < len(t):
            return ""

        left = 0
        shortest = 1e5
        res = [0,0]
        tMap = {}
        windowMap = {}

        for c in t:
            tMap[c] = tMap.get(c,0) + 1

        need = len(tMap)
        have = 0

        for right in range(len(s)):
            r = s[right]
            windowMap[r] = windowMap.get(r,0) + 1
            if r in tMap and windowMap[r] == tMap[r]:
                have += 1

            while need == have:
                l = s[left]
                if (right - left + 1) < shortest:
                    shortest = right - left + 1
                    res = [left, right]
                
                windowMap[l] -= 1
                left += 1

                if l in tMap and windowMap[l] < tMap[l]:
                    have -= 1

        left, right = res
        if shortest == 1e5:
            return ""

        return s[left : right+1]
