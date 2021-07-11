import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int p = 0;
        while (p < nums.length) {
            int num = nums[p];
            int resLen = res.size();
            for (int i = 0; i < resLen; i++) {
                List<Integer> newRes = new ArrayList<Integer>();
                newRes.addAll(res.get(i));
                newRes.add(num);
                res.add(newRes);
            }
            p++;
        }

        return res;
    }
}
// @lc code=end

