package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo121 {

    public int maxProfit(int[] prices) {

        return dp(prices,0);
    }

    // 找到比当前小的第一个开始递归
    public int dp(int[] prices, int n){
        int max = 0;
        for (int i = n + 1; i < prices.length; i++) {
            if(prices[i] < prices[n]){
                // 金额比买入小，递归点
                return Math.max(max,dp(prices,i));
            }else {
                // 比当前金额高记录最大值
                max = Math.max(prices[i] - prices[n],max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] values = new int[]{7,1,5,3,6,4};
//        int[] values = new int[]{7,6,4,3,1};
//        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        int[] values = new int[]{4, 6, 1, 10, 12, 14};
        System.out.println(new LeetCodeNo121().maxProfit(values));
    }
}
