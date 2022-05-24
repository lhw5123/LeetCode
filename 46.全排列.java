import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */

// @lc code=start
class Solution {
    private int[] used;
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        used = new int[len];
        List<Integer> p = new ArrayList<>();
        dfs(nums, 0, p);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            // 找到了一组解，注意要 copy 一个新的数组，不要直接插入 p
            List<Integer> sol = new ArrayList<>();
            sol.addAll(p);
            res.add(sol);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                p.add(nums[i]);
                dfs(nums, index + 1, p);
                p.remove(p.size() - 1);
                used[i] = 0;
            }
        }
    }
}
// @lc code=end

