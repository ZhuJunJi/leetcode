package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo309 {

    public int maxProfit(int[] prices) {
        int[] max = dp(prices,prices.length - 1);
        return Math.max(max[1],max[2]);
    }

    /**
     *
     * @param prices
     * @param n
     * 只有卖出股票后会冻结，只有当前不持股时会冻结，持有的情况不可能冻结
     * @return max[持有][不持股处于冷冻期][不持股不处于冻结]
     */
    public int[] dp(int[] prices, int n){
       if(n == 0) return new int[]{-prices[0],0,0};
       int[] max = dp(prices, n - 1);
       // 当天持有时的最大收益，是前一天就已经持有的，或者前一天不持有非冻结
       int max0 = Math.max(max[0],max[2] - prices[n]);
       // 当前不持股处于冷冻期是因为今天卖出了
       int max1 = max[0] + prices[n];
       // 当前不持股不处于冷冻期是因为今天啥也没干，前一天就已经不持股了，把前一天的冻结状态改为非冻结
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
        int[] values = new int[]{4, 6, 1, 10, 12, 14};
        System.out.println(new LeetCodeNo309().maxProfit(values));
    }
}
