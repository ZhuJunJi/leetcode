package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/6
 * @since 1.0
 */
public class LeetCodeNo1014 {

    public int maxScoreSightseeingPair(int[] values) {
        return dp(values,values.length - 1);
    }


    public int dp(int[] values, int n){
        if(n <= 1) return values[0] + values[1] - 1;
        int max = values[n];
        for (int i = 1; i <= values[n] && n - i >= 0; i++) {
            max = Math.max(max,values[n] + values[n - i] - i);
            if(values[n - i] > values[n] - i){
                return Math.max(max,dp(values,n - i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] values = new int[]{8,1,5,2,6};
        System.out.println(new LeetCodeNo1014().maxScoreSightseeingPair(values));
    }
}
