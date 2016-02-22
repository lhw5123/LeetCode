package com.hevin;

import com.hevin.array.CombinationSumII;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        CombinationSumII cs2 = new CombinationSumII();
        List<List<Integer>> ret = cs2.combinationSum2(arr, 8);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }
}
