# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

# P   A   H   N
# A P L S I I G
# Y   I   R
# And then read line by line: "PAHNAPLSIIGYIR"

# Write the code that will take a string and make this conversion given a number of rows:

# string convert(string s, int numRows);

# Zigzag pattern（之字形模式）是一种在不同领域（比如图形、金融、算法）都常见的模式。根据你想了解的上下文不同，含义略有差别。下面是几个常见的解释：

# ⸻

# 1. 在图形或排列上的 Zigzag Pattern

# 这是最直观的意思，就是“之”字形的排列，比如：
# 	•	排列元素时，第一行从左到右，第二行从右到左，第三行又从左到右……像蛇形一样反复折返。
# 	•	这种排列在图像显示、文字排版中经常出现。

# 📌 例子（矩阵中的 zigzag）：

# 1  2  3
# 6  5  4
# 7  8  9


# ⸻

# 2. 在算法或编程中的 Zigzag Pattern

# Zigzag 常用于遍历结构（如二叉树、矩阵、字符串）：
# 	•	Zigzag Level Order Traversal（LeetCode 常见题）指的是：层序遍历一棵树，但奇数层从左到右，偶数层从右到左。

# 📌 比如对于下面这棵树：

#     1
#    / \
#   2   3
#  / \   \
# 4   5   6

# 普通层序遍历结果是 [1, 2, 3, 4, 5, 6]，Zigzag 则是：

# [
#  [1],
#  [3, 2],
#  [4, 5, 6]
# ]


# ⸻

# 3. 在金融中的 Zigzag Pattern

# 在 技术分析（technical analysis）中，zigzag 是一种用来过滤价格图中“噪音”的指标：
# 	•	Zigzag 会只显示价格变动超过某个阈值（如 5%）的走势，用于识别主要趋势。
# 	•	它不用于预测未来，而是帮助交易者识别 趋势反转点。

# ⸻

# 4. 在字符串处理中的 Zigzag 转换

# 比如 LeetCode 的经典题「Zigzag Conversion」：

# 将字符串 “PAYPALISHIRING” 以 zigzag 形式写成如下形式（假设有3行）：

# P   A   H   N
# A P L S I I G
# Y   I   R

# 然后按行读取，输出结果为：“PAHNAPLSIIGYIR”

# ⸻

# 总结

# 应用领域	Zigzag Pattern 含义
# 图形/排列	之字形排列或走位
# 算法/编程	反复左右交错的遍历顺序
# 金融技术分析	用于趋势识别和消除价格图的噪音
# 字符串转换	将字符串以指定行数排成 zigzag，然后逐行读取

# In this problem, the Zigzag pattern is column first, from left to right.
import math

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # Handle edge cases
        if numRows == 1 or numRows >= len(s):
            return s

        # Create a list of strings, one for each row
        rows = [''] * numRows
        
        # Variables to track current direction and row
        index = 0
        step = 1
        
        # Iterate through the string and place each character in the appropriate row
        for char in s:
            rows[index] += char
            
            # Change direction when we reach the first or last row
            if index == 0:
                step = 1
            elif index == numRows - 1:
                step = -1
            
            # Move to the next row
            index += step
        
        # Combine all rows to form the result
        return ''.join(rows)