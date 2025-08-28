# Sort Matrix by Diagonals
# You are given an n x n square matrix of integers grid. Return the matrix such that:
# The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
# The diagonals in the top-right triangle are sorted in non-decreasing order.
class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        if n <= 1:
            return grid

        res = [row[:] for row in grid]

        # bottom-left triangle
        for i in range(n):
            y, x = i, 0
            temp = []
            while y < n and x < n:
                temp.append(grid[y][x])
                y += 1
                x += 1
            temp.sort(reverse=True)
            
            y, x = i, 0
            idx = 0
            while y < n and x < n:
                res[y][x] = temp[idx]
                y += 1
                x += 1
                idx += 1

        # top-right triangle
        for i in range(1, n):
            y, x = 0, i
            temp = []
            while y < n and x < n:
                temp.append(grid[y][x])
                y += 1
                x += 1
            temp.sort()

            y, x = 0, i
            idx = 0
            while y < n and x < n:
                res[y][x] = temp[idx]
                y += 1
                x += 1
                idx += 1
    
        return res
