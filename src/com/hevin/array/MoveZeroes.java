package com.hevin.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int rightPos = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                nums[rightPos++] = nums[curr];
            }
            curr++;
        }
        while (rightPos < nums.length) {
            nums[rightPos++] = 0;
        }
    }
}
