package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/4
 * @since 1.0
 */
public class LeetCodeNo55 {

    public boolean canJump(int[] nums) {
        return dp(nums,0);
    }

    public boolean dp(int[] nums, int n){
        // 已经能走完
        if(n >= nums.length - 1) return true;
        // 当前步 + 当前可走步能走完
        if(nums[n] + n >= nums.length - 1) return true;

        int next = maxCost(nums,n);
        if(next == n){
            if(nums[n + nums[n]] == 0) return false;
            return dp(nums,nums[n] + n);
        }else {
            return dp(nums,next);
        }
    }

    public int maxCost(int[] nums, int n){
        int max = nums[n] + n;
        int index = n;
        for (int i = n + 1; i <= n + nums[n]; i++) {
            if(max < i + nums[i]){
                max = i + nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,2,0,1,4};
        System.out.println(new LeetCodeNo55().canJump(nums));
    }
}
