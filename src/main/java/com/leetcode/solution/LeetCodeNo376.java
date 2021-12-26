package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/18
 * @since 1.0
 */
public class LeetCodeNo376 {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return 0;
        }


        return 0;
    }



    public static void main(String[] args) {
//        int[] nums = new int[]{1,7,4,9,2,5};
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(new LeetCodeNo376().wiggleMaxLength(nums));
    }
}
