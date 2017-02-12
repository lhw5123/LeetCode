package com.hevin.sort;

/**
 * 堆
 */
public class Heap {
    // 大顶堆
    public int[] heap;

    public Heap(int n) {
        heap = new int[n + 1];
    }

    // 元素自下而上变化
    private void swim(int k) {
        while (k > 1 && isLess(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    // 元素自上而下变化
    private void sink(int k) {
        int len = heap.length;
        while (2 * k <= len) {
            int i = 2 * k;
            if (i < len && isLess(i, i + 1)) {
                i++;
            }
            if (!isLess(k, i)) {
                break;
            }
            exchange(k, i);
            k = i;
        }
    }

    private boolean isLess(int a, int b) {
        return heap[a] < heap[b];
    }

    private void exchange(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
