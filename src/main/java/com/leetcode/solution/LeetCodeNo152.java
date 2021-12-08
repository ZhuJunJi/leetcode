package com.leetcode.solution;

import java.util.Arrays;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/4
 * @since 1.0
 */
public class LeetCodeNo152 {

    public int maxProduct(int[] nums) {
        int start = 0;
        int end = 0;
        int ans = product(nums,0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                ans = Math.max(ans,maxProductStartEnd(nums,start,end));
                start = i + 1;
            }else {
                end = i;
            }
        }
        if(nums[nums.length - 1] != 0){
            ans = Math.max(ans,maxProductStartEnd(nums,start,end));
        }
        return ans;
    }

    public int maxProductStartEnd(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int product = product(nums,start,end);
        if(product > 0){
            return product;
        }
        int product_pre = 1;
        for (int i = start; i <= end; i++) {
            // 第一次负就停止
            product_pre *= nums[i];
            if(product_pre < 0){
                break;
            }
        }
        int product_after = 1;
        for (int i = end; i >= start; i--) {
            // 第一次负就停止
            product_after *= nums[i];
            if(product_after < 0){
                break;
            }
        }

        return Math.max(product / product_pre, product / product_after);
    }

    // start -> end 乘积
    public int product(int[] nums, int start, int end){
        int product = 1;
        for (int i = start; i <= end; i++) {
            product *= nums[i];
            // 0 乘任何数都为 0
            if (product == 0){
                return product;
            }
        }
        return product;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,-4,-2,0,-2,-3,0};
        System.out.println(new LeetCodeNo152().maxProduct(nums));
    }

}
