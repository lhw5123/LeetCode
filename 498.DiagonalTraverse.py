# Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        if len(mat) == 0 or len(mat[0]) == 0:
            return []

        res = []       
        rows = len(mat)
        cols = len(mat[0])

        # In a rectangle, the number of diagonals equals rows + cols - 1.
        # As clockwise order.
        for i in range(rows + cols - 1):
            x = i if i < cols else cols - 1
            y = 0 if i < cols else i - cols + 1
            temp = []

            while x >= 0 and y < rows:
                temp.append(mat[y][x])
                x -= 1
                y += 1
            
            if i % 2 == 0:
                res.extend(temp[::-1])
            else:
                res.extend(temp)
        
        return res
