package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo714 {

    public int maxProfit(int[] prices, int fee) {
        int[] max = dp(prices, prices.length - 1, fee);
        return Math.max(max[1], max[2]);
    }

    /**
     * 1) 当天持有的最高收益             = 1。前一天就已经持有，2。或者今天才持有，前一天未持有的最高收益买入当前股票
     * 2）当前不持股交易的最高收益        = 卖出不持有的最高收益，之前持有的最高收益 + 当前股票的价格 - 手续费
     * 3）当前不持股没有交易的最高收益     = 前一天交易和非交易不持股的最高收益
     * @param prices
     * @param n
     * @param fee
     * @return
     */
    public int[] dp(int[] prices, int n, int fee){
        if(n == 0) return new int[]{-prices[0],0,0};
        int[] max = dp(prices, n - 1, fee);
        // 前一天就已经持有，或者前一天不持有
        int max0 = Math.max(max[0],Math.max(max[1] - prices[n],max[2] - prices[n]));
        // 当天不持有发生交易，前一天持有的最高收益
        int max1 = Math.max(max[0] + prices[n] - fee, max[1]);
        // 当前不持有没有发生交易,
        int max2 = Math.max(max[1],max[2]);

        max[0] = max0;
        max[1] = max1;
        max[2] = max2;
        return max;
    }




    public static void main(String[] args) {
//        int[] values = new int[]{7,1,5,3,6,4};
//        int[] values = new int[]{7,6,4,3,1};
//        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        int[] values = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new LeetCodeNo714().maxProfit(values,2));
    }
}
