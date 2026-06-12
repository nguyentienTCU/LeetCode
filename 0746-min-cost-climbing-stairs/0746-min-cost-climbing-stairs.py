class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # reach the current stair from 1 or 2 steps below
        # dp[] stores values where dp[i] means the minumum cost to reach that stair
        # dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        # dp[n] will be the top of the ladder

        n = len(cost)
        if n == 2:
            return min(cost[0], cost[1])

        cur = 0
        prev = 0

        for i in range(2, n+1):
            tmp = cur
            cur = min(cur + cost[i-1], prev + cost[i-2])
            prev = tmp

        return cur