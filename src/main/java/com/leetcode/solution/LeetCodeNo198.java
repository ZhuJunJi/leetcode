package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/2
 * @since 1.0
 */
public class LeetCodeNo198 {

    public int rob(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        return dp(nums,nums.length - 1, cache);
    }

    public int dp(int[] nums, int n, Map<Integer, Integer> cache){
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0],nums[1]);
        int rob = Math.max(nums[n] + (cache.containsKey(n - 2) ? cache.get( n - 2) : dp(nums,n - 2, cache)),
                cache.containsKey(n - 1) ? cache.get( n - 1): dp(nums, n - 1, cache));
        cache.put(n, rob);
        return rob;
    }
}
