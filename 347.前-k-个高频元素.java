import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    private class Item {
        int key;
        int count;

        public Item(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    // 用堆实现
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Item> countMap = new HashMap<>();
        for (int num : nums) {
            Item item = countMap.getOrDefault(num, new Item(num, 0));
            item.count++;
            countMap.put(num, item);
        }

        // 需要一个小顶堆
        PriorityQueue<Item> heap = new PriorityQueue<Item>(k, (a, b) -> (a.count - b.count));

        for (Map.Entry<Integer, Item> entry : countMap.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry.getValue());
            } else {
                Item top = heap.peek();
                if (entry.getValue().count > top.count) {
                    heap.poll();
                    heap.offer(entry.getValue());
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().key;
        }
        return res;
    }
}
// @lc code=end

