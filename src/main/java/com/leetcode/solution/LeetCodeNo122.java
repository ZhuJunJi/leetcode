package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        int p = prices[1] > prices[0] ? prices[0] : 0;
        for (int i = 1; i < (prices.length - 1); i++) {
            // 比后边小就买入
            if(prices[i] < prices[i - 1]){
                p = prices[i];
            }
            if(prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]){
                sum += prices[i] - p;
            }else {
                // 持有
                sum += prices[i] - p;
                p = prices[i];
            }
        }
        return sum;
    }



    public static void main(String[] args) {
//        int[] values = new int[]{7,1,5,3,6,4};
//        int[] values = new int[]{7,6,4,3,1};
//        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        int[] values = new int[]{4, 6, 1, 10, 12, 14};
        System.out.println(new LeetCodeNo122().maxProfit(values));
    }
}
