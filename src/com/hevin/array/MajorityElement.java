package com.hevin.array;

/**
 * Given an integer array of size n, find all elements that appear more than
 * ⌊ n/2 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = nums[0];
        for (int val : nums) {
            if (counter == 0) {
                candidate = val;
                counter = 1;
            } else if (val == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        counter = 0;
        for (int val : nums) {
            if (val == candidate) {
                counter++;
            }
        }
        if (counter < (nums.length + 1) / 2) {
            return -1;
        } else {
            return candidate;
        }
    }
}
