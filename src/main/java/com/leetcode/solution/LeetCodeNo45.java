package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/4
 * @since 1.0
 */
public class LeetCodeNo45 {

    public int jump(int[] nums) {
        return dp(nums,0, 0);
    }

    public int dp(int[] nums, int n, int step){
        // 已经能走完
        if(n >= nums.length - 1) return step;
        // 当前步 + 当前可走步能走完
        if(nums[n] + n >= nums.length - 1) return step + 1;
        // 找到下一步
        int next = maxCost(nums,n);
        if(next == n){
            return step;
        }else {
            return dp(nums,next,step + 1);
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
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new LeetCodeNo45().jump(nums));
    }
}
