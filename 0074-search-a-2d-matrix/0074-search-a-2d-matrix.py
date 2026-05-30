class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROW = len(matrix)
        COL = len(matrix[0])

        top = 0
        bottom = ROW-1
        while top <= bottom:
            mid = (top + bottom)//2
            if target < matrix[mid][0]:
                bottom = mid - 1
            elif target > matrix[mid][COL-1]:
                top = mid + 1
            else:
                break
        
        if not(top <= bottom):
            return False

        row = (top + bottom)//2
        left = 0
        right = COL-1
        while left <= right:
            mid = (left + right)//2
            if target < matrix[row][mid]:
                right = mid - 1
            elif target > matrix[row][mid]:
                left = mid + 1
            else:
                return True

        return False