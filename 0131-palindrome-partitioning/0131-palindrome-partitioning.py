class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j-i <= 2 or dp[i+1][j-1]):
                    dp[i][j] = True

        def backtrack(i, cur):
            if i >= len(s):
                res.append(cur.copy())
                return
            
            for j in range(i,len(s)):
                if dp[i][j]:
                    cur.append(s[i : j+1])
                    backtrack(j+1, cur)
                    cur.pop()

        backtrack(0, [])
        return res