class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = dict()
        for num in nums:
            map[num] = map.get(num, 0) + 1

        # [1:3; 2:2; 3:1]
        # key: the element itself
        # value: frequency of that element

        buckets = [[] for _ in range(len(nums)+1)]  
        # index will be the frequency, value will be the element

        res = []
        for key, value in map.items():
            buckets[value].append(key)
        
        # [[], [3], [2], [1], [], [], []]
        for i in range(len(buckets) - 1, -1, -1):
            for num in buckets[i]:
                res.append(num)
            if len(res) == k:
                return res



        