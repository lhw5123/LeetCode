package com.hevin.array;

import java.util.Random;

/**
 * 随机发牌程序
 */
public class RandomCards {
    public void randomCards() {
        int[] data = new int[52];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        for (int i = data.length - 1; i > 0; i--) {
            int tmp = random.nextInt(i + 1);
            swap(data, i, tmp);
        }
    }

    private void swap(int[] data, int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }
}
