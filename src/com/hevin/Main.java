package com.hevin;

<<<<<<< HEAD
import com.hevin.sort.LCD;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"4PGC938", "2IYE230", "1ICK750", "3ATW723"};
        LCD.sort(strs, 7);
        System.out.println(Arrays.toString(strs));
=======
import com.hevin.array.RemoveDuplicatesII;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 3};
        System.out.println(new RemoveDuplicatesII().removeDuplicates(arr));
>>>>>>> origin/master
    }
}
