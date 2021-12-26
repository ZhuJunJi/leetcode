package com.leetcode.solution;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/17
 * @since 1.0
 */
public class LeetCodeNo300 {


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
            dp[i] = Math.max(dp[i],1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new LeetCodeNo300().lengthOfLIS(nums));
    }
}
