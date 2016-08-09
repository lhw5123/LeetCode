package com.hevin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *  Design a data structure that supports all following operations in average O(1) time.
 *
 *  insert(val): Inserts an item val to the set if not already present.
 *  remove(val): Removes an item val from the set if present.
 *  getRandom: Returns a random element from current set of elements.
 *  Each element must have the same probability of being returned.
 */
public class RandomizedSet {

    private HashMap<Integer, Integer> locs;
    private List<Integer> nums;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        locs = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element.
     *
     *  HashMap 和 ArrayList 的插入操作都是 O(1).
     *  注意 HashMap 中是将要插入的值作为 key,当前元素个数作为 value.
     */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.
     *
     *
     */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int index = locs.get(val);
        if (index < nums.size() - 1) {
            int lastOne = nums.get(nums.size() - 1);
            nums.set(index, lastOne);
            locs.put(lastOne, index);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set.
     *
     * ArrayList 的 get 操作为 O(1).
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
