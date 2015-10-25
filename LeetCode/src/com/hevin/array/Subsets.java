package com.hevin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int totalNum = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < totalNum; i++) {
            List<Integer> set = new LinkedList<>();
            for (int j = 0, len = nums.length; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }
}
