class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = list(zip(position,speed))
        pair.sort(reverse=True)
        res = 1
        prevTime = (target-pair[0][0])/pair[0][1]
        for i in range(1,len(pair)):
            curTime = (target-pair[i][0])/pair[i][1]
            if curTime <= prevTime:
                continue
            res += 1
            prevTime = curTime
        return res