package com.hevin.array;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    /**
     * Find the contiguous subarray whithin an array witch has the lagest product.
     *
     * @param nums
     * @return 乘积
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxSofar = nums[0];
        int maxHere, minHere;
        for (int i = 1; i < nums.length; i++) {
            // 每遇到一个数，判断是继续乘，还是作为新数组的开端
            maxHere = Math.max(Math.max(maxHerePre * nums[i],
                    minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxHerePre * nums[i],
                    minHerePre * nums[i]), nums[i]);
            maxSofar = Math.max(maxHere, maxSofar);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSofar;
    }

}
