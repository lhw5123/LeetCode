package com.hevin.array;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int v : nums) {
            if (i < 2 || v > nums[i - 2]) {
                nums[i++] = v;
            }
        }
        return i;
    }
}