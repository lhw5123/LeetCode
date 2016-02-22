package com.hevin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(candidates);
        recurse(new ArrayList<>(), target, candidates, 0, ret);
        return ret;
    }

    private void recurse(List<Integer> list, int target, int[] candidates, int index,
            List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                recurse(copy, newTarget, candidates, i, ret);
            }
        }
    }
}
