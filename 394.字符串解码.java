import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    int p;

    public String decodeString(String s) {
        LinkedList<Integer> digitStack = new LinkedList<>();
        LinkedList<String> stringStack = new LinkedList<>();
        p = 0;
        while (p < s.length()) {
            char cur = s.charAt(p);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                digitStack.add(Integer.valueOf(digits));
            } else if (Character.isLetter(cur) || cur == '[') {
                stringStack.add(String.valueOf(cur));
                p++;
            } else {
                p++;
                LinkedList sub = new LinkedList<>();
                while (!"[".equals(stringStack.peekLast())) {
                    sub.addFirst(stringStack.removeLast());
                }
                // 左括号出栈。
                stringStack.removeLast();
                String subStr = getString(sub);
                int count = digitStack.removeLast();
                StringBuffer t = new StringBuffer();
                while (count-- > 0) {
                    t.append(subStr);
                }
                stringStack.add(t.toString());
            }
        }
        return getString(stringStack);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(p))) {
            ret.append(s.charAt(p++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
// @lc code=end

