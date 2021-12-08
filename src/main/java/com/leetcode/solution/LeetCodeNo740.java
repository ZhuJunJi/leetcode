package com.leetcode.solution;

import com.leetcode.solution.data.structure.Array;

import java.util.*;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/2
 * @since 1.0
 */
public class LeetCodeNo740 {
    // [0,0,2,3,4,0]

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        return dp(sums,sums.length - 1, cache);
    }

    public int dp(int[] nums, int n, Map<Integer, Integer> cache){
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0],nums[1]);
        int rob = Math.max(nums[n] + (cache.containsKey(n - 2) ? cache.get( n - 2) : dp(nums,n - 2, cache)),
                cache.containsKey(n - 1) ? cache.get( n - 1): dp(nums, n - 1, cache));
        cache.put(n, rob);
        return rob;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 4, 2};
//        int[] nums = new int[]{2,2,3,3,3,4};
//        int[] nums = new int[]{2,2,3,3,3,4};
//        int[] nums = new int[]{1,1,1,2,4,5,5,5,6};
                int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(new LeetCodeNo740().deleteAndEarn(nums));
    }


}
