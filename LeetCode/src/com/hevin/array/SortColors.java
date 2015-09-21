package com.hevin.array;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        // 用插入排序求解
        for (int i = 1, len = nums.length; i < len; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1]  = tmp;
                j--;
            }
        }
    }
}
