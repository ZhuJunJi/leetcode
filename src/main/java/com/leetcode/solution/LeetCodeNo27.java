package com.leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhujunji
 * @date 2020-06-26
 */
public class LeetCodeNo27 {

    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // index 与 val 相等的第一个元素
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                if(index != i){
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        while (index < nums.length) {
            if(nums[index] == val){
                int nextNoEqValIndex = getNextNoEqVal(nums,val,index + 1);
                if(nextNoEqValIndex == -1){
                    return index;
                }
                swap(nums,index,nextNoEqValIndex);
            }
            index++;
        }
        return index;
    }

    /**
     * 返回值在【0..nums.length）说明找到结果
     * 不存在与 val 不同的元素返回 -1
     *
     * @param nums
     * @param val
     * @param start
     * @return
     */
    private int getNextNoEqVal(int[] nums, int val, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != val) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int element = removeElement1(nums, 2);
        System.out.println(element);
        System.out.println(Arrays.toString(nums));
    }
}
