package com.hevin.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class FindMedianFromDataStream {
    private Queue<Long> small;      // 大顶堆存放较小的部分
    private Queue<Long> large;      // 小顶堆存放较大的部分

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    /**
     * Add a integer number from the data stream to the data structure.
     *
     * @param num
     */
    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
    }
}
