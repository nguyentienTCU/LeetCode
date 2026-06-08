class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def backtrack(cur, i, total):
            if total == target:
                res.append(cur.copy())
                return
            
            for j in range(i,len(candidates)):
                if total + candidates[j] > target:
                    break
                
                if j > i and candidates[j] == candidates[j-1]:
                    continue
                
                cur.append(candidates[j])
                backtrack(cur, j+1, total + candidates[j])
                cur.pop()

        backtrack([], 0, 0)
        return res