package com.hevin.array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (
 * ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs
 * are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    /**
     * 思路：
     * 1.从数组最后找第一个下标i，满足nums[i-1] < nums[i]，这说明nums[i]-nums[end]都是逆序。
     * 2.找到仅比nums[i]大的数，交换位置。
     * 3.将nums[i]-nums[end]颠倒。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        int i = nums.length - 1;
        int j;
        for(j = nums.length - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {
                break;
            }
        }
        if (j >= 0) {
            while (nums[i] <= nums[j]) {
                i--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, j + 1, nums.length - 1);
    }

    /**
     * 将数组颠倒
     * @param nums 数组
     * @param begin 开始序号
     * @param end 结束序号
     */
    private void reverse(int[] nums, int begin, int end) {
        if (begin > end && (begin < 0 || end >= nums.length - 1)) {
            return;
        }
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }
}
