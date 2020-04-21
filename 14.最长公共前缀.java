/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.40%)
 * Total Accepted:    54.2K
 * Total Submissions: 169K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String subStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(subStr) != 0) {  // .indexOf(subStr) == 0 说明 subStr 是 strs[i] 的前缀。
                subStr = subStr.substring(0, subStr.length() - 1);
                if (subStr.isEmpty()) {
                    subStr = "";
                    break;
                }
            }
        }

        return subStr;
    }
}

