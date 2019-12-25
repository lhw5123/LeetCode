import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.containsValue(ch)) {
                if (stack.isEmpty() || map.get(stack.peek()) != ch) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

