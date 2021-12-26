package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo122 {

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int p = prices[1] > prices[0] ? prices[0] : -1;
        int sum = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            // 买进
            if(prices[i -1] >= prices[i] && prices[i + 1] > prices[i]){
                p = prices[i];
            }
            // 卖出  n - 1 < n and n + 1 >= n
            if(prices[i - 1] < prices[i] && prices[i + 1] <= prices[i]){
                sum += prices[i] - p;
                p = -1;
            }
        }
        if(p != -1){
            sum += prices[prices.length - 1] - p;
        }
        return sum;
    }

    /**
     *
     * @param prices
     * @param n
     * @return max[第 i 天不持股的最大收益][第 i 天持股的最大收益]
     */
    public int[] dp(int[] prices, int n){
        if(n == 0) return new int[]{0,-prices[0]};
        int[] max = dp(prices,n - 1);
        // 当前不持股最大收益是前一天持有时的最大收益 + 当前股价
        int max0 = Math.max(max[1] + prices[n],max[0]);
        // 当前持股的最大收益是前一天未持有的最大收益 - 当前股价
        int max1 = Math.max(max[0] - prices[n],max[1]);

        max[0] = max0;
        max[1] = max1;
        return max;
    }



    public static void main(String[] args) {
//        int[] values = new int[]{7,1,5,3,6,4};
//        int[] values = new int[]{7,6,4,3,1};
//        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        int[] values = new int[]{4, 6, 1, 10, 12, 14};
        System.out.println(new LeetCodeNo122().maxProfit(values));
        int[] max = new LeetCodeNo122().dp(values,values.length - 1);
    }
}
