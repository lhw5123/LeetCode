package com.hevin.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.equals("")) {
            return b;
        }
        if (b == null || b.equals("")) {
            return a;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while (i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aChars[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bChars[j--]) : 0;
            result = aByte ^ bByte ^ carry; // 用位异或操作
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.insert(0, result);
        }
        return stb.toString();
    }
}
