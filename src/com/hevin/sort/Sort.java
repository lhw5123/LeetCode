package com.hevin.sort;

/**
 * 排序算法
 */
public class Sort {

    /**
     * 快速排序
     *
     * @param a
     */
    public static void quickSort(Comparable[] a) {
        qucikInnerSort(a, 0, a.length - 1);
    }

    private static void qucikInnerSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 三向切分，将和切分元素相等的元素归为
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        qucikInnerSort(a, lo, lt - 1);
        qucikInnerSort(a, gt + 1, hi);
    }

    // 获得切分值
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int mid = lo + (hi - lo) / 2;
        if (isLess(a[lo], a[mid])) {
            exch(a, lo, mid);
        }
        if (isLess(a[hi], a[mid])) {
            exch(a, mid, hi);
        }
        if (isLess(a[hi], a[lo])) {
            exch(a, lo, hi);
        }
        Comparable v = a[lo];
        while (true) {
            while (isLess(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (isLess(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static Comparable[] aux;

    /**
     * 自底向上的归并排序
     *
     * @param a
     */
    public static void mergeSort(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];
        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int lo = 0; lo < len - sz; lo += sz + sz) {     // sz字数组大小
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, len - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (isLess(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertSort(Comparable[] a) {
        for (int i = 1, len = a.length; i < len; i++) {
            int j = i;
            while (j > 0 && isLess(a[j], a[j - 1])) {
                exch(a, j, j - 1);
                j--;
            }
        }
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (isLess(arr[i + 1], arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLess(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
