class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def backtrack(cur, total, i):
            if total == target:
                res.append(cur.copy())
                return

            for j in range(i,len(candidates)):
                if total + candidates[j] > target:
                    break

                cur.append(candidates[j])
                backtrack(cur,total+candidates[j],j)
                cur.pop()


        backtrack([], 0, 0)
        return res