package com.hevin.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxCur = 0;
        int max = nums[0];
        for (int var : nums) {
            maxCur = Math.max(var, maxCur + var);
            max = Math.max(max, maxCur);
        }
        return max;
    }
}
