class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = dict()
        for word in strs:
            key = "".join(sorted(word))
            map[key] = map.get(key, []) + [word]

        return list(map.values())