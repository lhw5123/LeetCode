class Spreadsheet:

    def __init__(self, rows: int):
        self.cells = {}

    def setCell(self, cell: str, value: int) -> None:
        self.cells[cell] = value

    def resetCell(self, cell: str) -> None:
        if cell in self.cells:
            del self.cells[cell]

    def getValue(self, formula: str) -> int:
        formula = formula.strip()

        if not formula.startswith("="):
            if formula in self.cells:
                return self.cells[formula]
            try:
                return int(formula)
            except:
                return 0
        
        parts = formula[1:].split("+")
        if len(parts) != 2:
            return 0
        
        # Evaluate X
        x = parts[0].strip()
        if x in self.cells:
            x_val = self.cells[x]
        else:
            try:
                x_val = int(x)
            except:
                x_val = 0

        # Evaluate Y
        y = parts[1].strip()
        if y in self.cells:
            y_val = self.cells[y]
        else:
            try:
                y_val = int(y)
            except:
                y_val = 0
        
        return x_val + y_val



# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)