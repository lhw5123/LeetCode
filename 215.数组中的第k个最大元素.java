import java.util.PriorityQueue;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    // 基于快速排序思想实现的快速查找
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int lo = 0, hi = nums.length - 1;
        // 转换成：从小到大排名第 k 大的元素
        k = nums.length - k;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int p = i + rand.nextInt(n - i);
            swap(nums, i, p);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 用小顶堆实现
    private int findKthLargest2(int[] nums, int k) {
        // min-top heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.peek();
    }
}
// @lc code=end

