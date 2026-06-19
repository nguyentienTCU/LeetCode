class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        pac = set()
        atl = set()
        ROWS = len(heights)
        COLS = len(heights[0])
        def dfs(r,c, visit, prevHeight):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS or (r,c) in visit:
                return
            
            if heights[r][c] >= prevHeight:
                visit.add((r,c))
                prev = heights[r][c]
                dfs(r+1, c, visit, prev)
                dfs(r-1, c, visit, prev)
                dfs(r, c-1, visit, prev)
                dfs(r, c+1, visit, prev)
        
        for c in range(COLS):
            dfs(0,c,pac,0)
            dfs(ROWS-1,c,atl,0)
        
        for r in range(ROWS):
            dfs(r,0,pac,0)
            dfs(r,COLS-1,atl,0)

        res = []
        for r in range(ROWS):
            for c in range(COLS):
                if (r,c) in pac and (r,c) in atl:
                    res.append([r,c])

        return res
