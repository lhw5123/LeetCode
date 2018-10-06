package com.hevin.array;

/**
 * 有一个二维数组。其每一行从左到右递增，每一列从上到下递增。
 * 输入一个整数，判断该二维数组中是否包含该数字。
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix) {
            return false;
        }
        boolean found = false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (columns > 0) {
            int row = 0, column = columns - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                } else if (matrix[row][column] < target) {
                    row++;
                } else {
                    column--;
                }
            }
        }
        return found;
    }
}
