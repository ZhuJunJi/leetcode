package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/5
 * @since 1.0
 */
public class LeetCodeNo1567 {


    public int getMaxLen(int[] nums) {
        int start = 0;
        int end = 0;
        if (!hasZero(nums, 0, nums.length - 1) && productIsPositive(nums, 0, nums.length - 1)) return nums.length;

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxLen = Math.max(maxLenPositiveProduct(nums, start, end), maxLen);
                start = i + 1;
            } else {
                end = i;
            }
        }

        if (nums[nums.length - 1] != 0) {
            maxLen = Math.max(maxLenPositiveProduct(nums, start, end), maxLen);
        }

        return maxLen;
    }

    public int maxLenPositiveProduct(int[] nums, int start, int end) {
        if (hasZero(nums, start, end)) return 0;
        if (productIsPositive(nums, start, end)) return end - start + 1;
        int temp_start = start;
        int temp_end = end;
        for (int i = start; i <= end; i++) {
            temp_start++;
            if (nums[i] < 0) {
                break;
            }
        }
        for (int i = end; i >= start; i--) {
            temp_end--;
            if (nums[i] < 0) {
                break;
            }
        }
        return Math.max(end - temp_start + 1, temp_end - start + 1);
    }

    public boolean hasZero(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean productIsPositive(int[] nums, int start, int end) {
        int countNegative = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < 0) {
                countNegative++;
            }
        }
        return countNegative % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 10, 1, 0, 19, 20, -28, 30, -12, 20, 11, -8, 7, 21, -26};
        System.out.println(new LeetCodeNo1567().getMaxLen(nums));
    }


}
