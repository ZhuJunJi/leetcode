package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/11
 * @since 1.0
 */
public class LeetCodeNo264 {

    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] res = new int[3];
        int[] nums = new int[n];
        dp(nums,res,n - 1);
        return nums[n - 1];
    }

    private void dp(int[] nums, int[] res, int n){
        if(n == 0){
            nums[0] = 1;
            res[0] = 0;
            res[1] = 0;
            res[2] = 0;
            return;
        }
        dp(nums, res, n - 1);
        int num2 = nums[res[0]] * 2;
        int num3 = nums[res[1]] * 3;
        int num5 = nums[res[2]] * 5;
        nums[n] = Math.min(Math.min(num2,num3),num5);
        if(nums[n] == num2){
            res[0]++;
        }
        if(nums[n] == num3){
            res[1]++;
        }
        if(nums[n] == num5){
            res[2]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeNo264().nthUglyNumber(16));
    }
}
