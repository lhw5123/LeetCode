package com.hevin.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMartix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) {
            return binarySearch(matrix[0], target);
        }
        int len = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][len]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }
        if (arr.length == 1) {
            return target == arr[0];
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
