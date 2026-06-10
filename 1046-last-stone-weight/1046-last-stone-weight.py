class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap = [-s for s in stones] 
        heapq.heapify(maxHeap)
        while len(maxHeap) > 1:
            heaviest = heapq.heappop(maxHeap)
            secondHeaviest = heapq.heappop(maxHeap)
            if heaviest == secondHeaviest:
                continue
            heapq.heappush(maxHeap, heaviest - secondHeaviest)
        
        return 0 if not maxHeap else - maxHeap[0]
        