package com.hevin.array;

/**
 * 找出第 k 大的数字。
 */
public class FindKMaxNumber {

    public static int find(int[] arr, int k, int low, int high) {
        if (k > arr.length) {
            throw new IllegalArgumentException();
        }
        int pivotPos = partition(arr, low, high);
        int result;
        if (pivotPos + 1 == k) {
            result = arr[pivotPos];
        } else if (k > pivotPos + 1) {
            result = find(arr, k, pivotPos + 1, high);
        } else {
            result = find(arr, k, low, pivotPos - 1);
        }
        return result;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
