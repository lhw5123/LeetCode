package com.hevin.array;

public class Fibonacci {

    /**
     * 求斐波那契数列的第 n 项值。
     *
     * @param n 第 n 项。
     * @return 第 n 项的值。
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int t1 = 1, t2 = 0, tn = 0;
        for (int i = 2; i < n; i++) {
            tn = t1 + t2;
            t2 = t1;
            t1 = tn;
        }
        return tn;
    }
}
