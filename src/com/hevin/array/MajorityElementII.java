package com.hevin.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than
 * ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {
    /**
     * Use Boyer-Moore majority vote algorithm.
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int counter1 = 0;
        int counter2 = 0;
        int candidate1 = 0;
        int candidate2 = 1;
        for (int val : nums) {
            if (val == candidate1) {
                counter1++;
            } else if (val == candidate2) {
                counter2++;
            } else if (counter1 == 0) {
                candidate1 = val;
                counter1 = 1;
            } else if (counter2 == 0) {
                candidate2 = val;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int val : nums) {
            if (val == candidate1) {
                counter1++;
            }
            if (val == candidate2) {
                counter2++;
            }
        }
        if (counter1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (counter2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
