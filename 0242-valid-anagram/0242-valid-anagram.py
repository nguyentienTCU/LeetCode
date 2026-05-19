class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        map = dict()
        for c in s:
            map[c] = map.get(c, 0) + 1

        for c in t:
            if c not in map:
                return False
            if map[c] <= 0:
                return False
            map[c] -= 1

        return True