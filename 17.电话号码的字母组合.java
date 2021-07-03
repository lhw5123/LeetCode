import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
// 回溯算法
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        String[] letterMap = {
            " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = letterMap[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String tmp = res.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }
}
// @lc code=end

