package com.hevin;

import com.hevin.array.SearchForARange;
import com.hevin.array.SearchInRotatedSortedArrayII;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4};
        System.out.println(Arrays.toString(SearchForARange.searchRange(nums, 2)));
    }
}
