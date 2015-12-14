package com.hevin.array;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;  // 可能会造成溢出
        for (int var : nums) {
            sum -= var;
        }
        return sum;
    }

    public static int missingNumber2(int[] nums) {
        // XOR
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
