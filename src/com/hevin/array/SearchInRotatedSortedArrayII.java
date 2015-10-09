package com.hevin.array;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[lo] < nums[mid]) { // left half is sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > nums[mid]) {   // right half is sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo++;
            }
        }
        return false;
    }
}
