package com.hevin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recurse(new ArrayList<>(), target, candidates, 0, result);
        return result;
    }

    private void recurse(List<Integer> list, int target, int[] candidates,
            int index, List<List<Integer>> ret) {
        if (target == 0) {
            for(List l : ret) { // 去重
                if (l.equals(list)) {
                    return;
                }
            }
            ret.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                // 确保数组中的每个数字只出现一次
                recurse(copy, newTarget, candidates, i + 1, ret);
            }
        }
    }
}
