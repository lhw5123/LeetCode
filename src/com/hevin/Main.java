package com.hevin;

import com.hevin.array.CombinationSumII;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    private void findMax(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] rowsMax = new int[rows];

        for (int i = 0; i < rows; i++) {
            rowsMax[i] = matrix[i][0];
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > rowsMax[i]) {
                    rowsMax[i] = matrix[i][j];
                }
                if (j >= 1 && matrix[i][j] < matrix[i - 1][j]) {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

}
