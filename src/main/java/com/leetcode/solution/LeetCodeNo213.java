package com.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/2
 * @since 1.0
 */
public class LeetCodeNo213 {

    public static int rob(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        // 选择偷最后一间和不偷最后一间中选择利益最大的
        int rob = dp(nums,1,nums.length - 1, cache);
        cache.clear();
        return Math.max(rob, dp(nums,0,nums.length - 2, cache)) ;
    }

    public static int dp(int[] nums, int m, int n, Map<Integer, Integer> cache){
        if(n <= m) return nums[m];
        if(n == m + 1) return Math.max(nums[m],nums[m + 1]);
        int rob = Math.max(nums[n] + (cache.containsKey(n - 2) ? cache.get( n - 2) : dp(nums, m,n - 2, cache)),
                cache.containsKey(n - 1) ? cache.get( n - 1): dp(nums, m,n - 1, cache));
        cache.put(n, rob);
        return rob;
    }

    public static void main(String[] args) {
        System.out.println(8 >> 1);
        int[] nums = new int[]{0};
        System.out.println(rob(nums));
    }
}
