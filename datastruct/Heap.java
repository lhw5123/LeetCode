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
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = val;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(arr, i, i / 2);
            i /= 2;
        }
    }

    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        a[1] = a[count];
        int max = a[count];
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
            if (i * 2 <= size && arr[i] < arr[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= size && arr[maxPos] < arr[i * 2 + 1]) {
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
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }
}
