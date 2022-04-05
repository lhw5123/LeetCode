import java.util.Comparator;

// 小顶堆
public class Heap {
    // 堆的最大容量。
    private int cap;
    // 当前装了多少元素。
    private int count;
    // 堆是一个完全二叉树，因此用数组来保存最好。
    private int[] arr;

    public Heap(int capacity) {
        this.cap = capacity;
        this.count = 0;
        // 从 index = 1 开始保存数据。
        this.arr = new int[capacity + 1];
    }

    public void insert(int val) {
        if (count >= cap) {
            return;
        }
        ++count;
        arr[count] = val;
        int i = count;
        // 因为是从 index=1 开始保存数据，因此下标 i 元素的父节点就是 i / 2
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        arr[1] = arr[count];
        int max = arr[count];
        --count;
        heapify(count);
        return max;
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void heapify(int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= cap && arr[i] < arr[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= cap && arr[maxPos] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap() {
        for (int i = cap / 2; i >= 1; i--) {
            heapify(i);
        }
    }
}
