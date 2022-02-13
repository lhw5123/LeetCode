import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 找三个和为 0 的数
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> twoSumAns = twoSum(nums, i + 1, target);
            for (List<Integer> twoSum : twoSumAns) {
                ans.add(Arrays.asList(nums[i], twoSum.get(0), twoSum.get(1)));
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return ans;
    }

    // 要保证传入的 nums 必须是有序的。
    // 返回的是两个值，而不是下标。
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int l = start, r = nums.length - 1;
        // 在 while 中做索引移动，一定要重复判断索引关系。
        while (l < r) {
            int lv = nums[l], rv = nums[r];
            if (lv + rv == target) {
                res.add(Arrays.asList(lv, rv));
                while (l < r && nums[l] == lv) {
                    l++;
                }
                while (l < r && nums[r] == rv) {
                    r--;
                }
            } else if (lv + rv < target) {
                while (l < r && nums[l] == lv) {
                    l++;
                }
            } else {
                while (l < r && nums[r] == rv) {
                    r--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

