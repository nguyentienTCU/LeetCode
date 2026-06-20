class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS = len(board)
        COLS = len(board[0])
        directions = [[-1,0], [1,0], [0,-1], [0,1]]
        q = deque()
        for r in range(ROWS):
            for c in range(COLS):
                if (r == 0 or c == 0 or r == ROWS-1 or c == COLS-1) and board[r][c] == "O":
                    q.append([r,c])
        
        while q:
            r,c = q.popleft()
            if board[r][c] == "O":
                board[r][c] = "T"
                for dr,dc in directions:
                    row = r + dr
                    col = c + dc
                    if 0 <= row < ROWS and 0 <= col < COLS:
                        q.append([row,col])

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "T":
                    board[r][c] = "O"
                elif board[r][c] == "O":
                    board[r][c] = "X"