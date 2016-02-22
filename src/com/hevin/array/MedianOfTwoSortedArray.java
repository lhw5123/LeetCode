package com.hevin.array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) +
                    findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }

    /**
     * 在两个排好序的数组中查找第k个数
     */
    private int findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        int mid = k / 2 - 1;
        int aKey = aStart + mid < A.length ? A[aStart + mid] : Integer.MAX_VALUE;
        int bKey = bStart + mid < B.length ? B[bStart + mid] : Integer.MAX_VALUE;

        int kNew = k - k / 2;

        if (aKey <= bKey) {
            return findKth(A, aStart + k / 2, B, bStart, kNew);
        } else {
            return findKth(A, aStart, B, bStart + k / 2, kNew);
        }
    }
}
