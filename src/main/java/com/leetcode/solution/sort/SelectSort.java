package com.leetcode.solution.sort;

import java.util.Arrays;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/9
 * @since 1.0
 */
public class SelectSort {

    public void sort(int[] nums) {
        sort(nums, true);
    }

    public void sort(int[] nums, boolean asc) {
        if (asc) {
            for (int i = 0; i < nums.length; i++) {
                int maxIndex = getMaxIndex(nums, 0, nums.length - i);
                if (maxIndex != nums.length - i - 1) {
                    swap(nums, maxIndex, nums.length - i - 1);
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int maxIndex = getMaxIndex(nums, i, nums.length);
                if (maxIndex != i) {
                    swap(nums, maxIndex, i);
                }
            }
        }


    }

    /**
     * [start...end) 范围找最大值所在的索引
     *
     * @param nums
     * @param start
     * @param end
     * @return int 指定范围内最大值所在的索引
     */
    public int getMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * 交换 a b 索引位置的值
     *
     * @param nums
     * @param a
     * @param b
     */
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 2, 8, 5, 1, 0};
        new SelectSort().sort(nums,false);
        System.out.println(Arrays.toString(nums));
    }
}
