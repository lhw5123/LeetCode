import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    // @param nums 必须是一个有序数组
    // @param n 几数之和
    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int len = nums.length;
        if (n < 2 || len < n) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            // 2 sum, 双指针的做法
            int lo = start, hi = len - 1;
            while (lo < hi) {
                int lv = nums[lo], hv = nums[hi];
                if (lv + hv > target) {
                    while (lo < hi && nums[hi] == hv) {
                        hi--;
                    }
                } else if (lv + hv < target) {
                    while (lo < hi && nums[lo] == lv) {
                        lo++;
                    }
                } else {
                    res.add(Arrays.asList(lv, hv));
                    while (lo < hi && nums[hi] == hv) {
                        hi--;
                    }
                    while (lo < hi && nums[lo] == lv) {
                        lo++;
                    }
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                final Integer numsI = nums[i];
                for (List<Integer> list : sub) {
                    List<Integer> subRes = new ArrayList<>(){
                        {
                            add(numsI);
                            addAll(list);
                        }
                    };
                    res.add(subRes);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return res;
    }
}
// @lc code=end

