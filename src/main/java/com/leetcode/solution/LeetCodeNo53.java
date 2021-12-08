package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/4
 * @since 1.0
 */
public class LeetCodeNo53 {



    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(sum,ans);
        }
        return ans;

    }



    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LeetCodeNo53().maxSubArray(nums));
    }
}
