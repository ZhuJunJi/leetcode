package com.leetcode.solution;

import java.util.Arrays;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/4
 * @since 1.0
 */
public class LeetCodeNo918 {

    public int maxSubarraySumCircular(int[] nums) {
        int max = maxSubArray(nums, 1);
        return max < 0 ? max : Math.max(max, sum(nums) + maxSubArray(nums, -1));
    }

    /**
     * 以 n 结尾能够得到得最大连续子数组和
     * @param nums
     * @param n
     * @return max
     */
    public int dpMaxSumEndWithN(int[] nums, int n){
        if(n == 0) return nums[0];
        // 当前 + 以前一个元素结尾的最大连续子数组和，为负的情况不加
        return nums[n] + Math.max(0, dpMaxSumEndWithN(nums, n - 1));
    }

    public int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public int maxSubArray(int[] nums, int p) {
        int ans = nums[0] * p;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += (num * p);
            } else {
                sum = num * p;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -3, -1};
        System.out.println(new LeetCodeNo918().maxSubarraySumCircular(nums));
    }

}
