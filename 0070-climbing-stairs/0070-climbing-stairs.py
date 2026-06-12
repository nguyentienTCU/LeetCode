class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1

        firstPrev = 1
        secondPrev = 1
        cur = 0
        for i in range(2,n+1):
           cur = firstPrev + secondPrev
           secondPrev = firstPrev
           firstPrev = cur
        return cur
