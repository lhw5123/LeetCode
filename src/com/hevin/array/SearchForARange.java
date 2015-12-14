package com.hevin.array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        // search for the left one.
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] != target) {
            return result;
        } else {
            result[0] = lo;
        }
        // search for the right one.
        hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        result[1] = hi;
        return result;
    }
}
