import java.util.Random;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        // 把 i, j 定义为开区间，同时定义：
        // [left, i) <= pivot; (j, right] > pivot
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数 
            int r = i + random.nextInt(n - i);
            swap(nums, i, r);
        }
    }
}
// @lc code=end

