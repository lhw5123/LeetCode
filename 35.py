class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.rows = [0] * 9
        self.cols = [0] * 9
        self.boxes = [0] * 9

        for y in range(9):
            for x in range(9):
                if board[y][x] != '.':
                    num = int(board[y][x])
                    mask = 1 << (num - 1)
                    self.rows[y] |= mask
                    self.cols[x] |= mask
                    self.boxes[(y // 3) * 3 + x // 3] |= mask

        self.backtrack(board, 0, 0)
    
    def backtrack(self, board: List[List[str]], x: int, y: int) -> bool:
        if x == 9:
            return self.backtrack(board, 0, y + 1)
        
        if y == 9:
            return True
        
        # We don't need to 
        if board[y][x] != '.':
            return self.backtrack(board, x + 1, y)

        # Calcualte it is which 3x3 box
        box_idx = (y // 3) * 3 + x // 3
    
        for num in range(1, 10):
            mask = 1 << (num - 1)
            if not (self.rows[y] & mask) and not (self.cols[x] & mask) and not (self.boxes[box_idx] & mask):
                board[y][x] = str(num)
                self.rows[y] |= mask
                self.cols[x] |= mask
                self.boxes[box_idx] |= mask

                if self.backtrack(board, x + 1, y):
                    return True
                
                board[y][x] = '.'
                self.rows[y] &= ~mask
                self.cols[x] &= ~mask
                self.boxes[box_idx] &= ~mask

        return False