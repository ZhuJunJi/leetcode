package com.leetcode.solution;

import java.util.*;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/20
 * @since 1.0
 */
public class LeetCodeNo377 {

    Map<Integer ,Integer> cache = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        cache.clear();
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int remains) {
        if(remains == 0) return 1;

        if (cache.containsKey(remains)) return cache.get(remains);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(remains >= nums[i]){
                res += backtrack(nums,remains - nums[i]);
            }
        }
        cache.put(remains, res);
        return res;
    }
}
