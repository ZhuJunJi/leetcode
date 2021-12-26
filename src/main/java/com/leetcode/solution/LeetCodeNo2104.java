package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/17
 * @since 1.0
 */
public class LeetCodeNo2104 {

    public long subArrayRanges(int[] nums) {

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new LeetCodeNo2104().subArrayRanges(nums));
    }
}
