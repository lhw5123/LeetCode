package com.hevin;

import com.hevin.sort.LCD;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"4PGC938", "2IYE230", "1ICK750", "3ATW723"};
        LCD.sort(strs, 7);
        System.out.println(Arrays.toString(strs));
    }
}
