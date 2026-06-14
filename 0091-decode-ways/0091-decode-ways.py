class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = 0
        dp1 = 1
        dp2 = 0
        for i in range(n-1,-1,-1):
            if s[i] == "0":
                dp = 0
            elif (i+1 < n) and (s[i] == "1" or (s[i] == "2" and s[i+1] in ["0","1","2","3","4","5","6"])):
                dp = dp1 + dp2
            else:
                dp = dp1
            dp2 = dp1
            dp1 = dp
        return dp