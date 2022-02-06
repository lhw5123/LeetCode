import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minAbsDiff = Math.abs(arr[1] - arr[0]);
        ans.add(Arrays.asList(arr[0], arr[1]));
        for (int i = 1; i < arr.length - 1; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int absDiff = Math.abs(first - second);
            if (absDiff == minAbsDiff) {
                ans.add(Arrays.asList(first, second));
            } else if (absDiff < minAbsDiff) {
                minAbsDiff = Math.abs(second - first);
                ans.clear();
                ans.add(Arrays.asList(first, second));
            }
        }
        return ans;
    }
}
// @lc code=end

