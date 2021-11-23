import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        int[] used = new int[len];
        dfs(nums, 0, p, res, used);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> p, List<List<Integer>> res, int[] used) {
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
                dfs(nums, index + 1, p, res, used);
                p.remove(p.size() - 1);
                used[i] = 0;
            }
        }
    }
}
// @lc code=end

