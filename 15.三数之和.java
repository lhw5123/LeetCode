import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, target);
            for (List<Integer> list : twoSumRes) {
                res.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    // 要保证传入的 nums 必须是有序的。
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;
        while (l < r) {
            int lv = nums[l], rv = nums[r];
            if (lv + rv < target) {
                while (l < r && nums[l] == lv) {
                    l++;
                }
            } else if (lv + rv > target) {
                while (l < r && nums[r] == rv) {
                    r--;
                }
            } else if (lv + rv == target) {
                res.add(Arrays.asList(lv, rv));
                while (l < r && nums[l] == lv) {
                    l++;
                }
                while (l < r && nums[r] == rv) {
                    r--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

