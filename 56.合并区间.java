import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            };
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                last[1] = Math.max(last[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

