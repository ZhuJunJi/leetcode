package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/9
 * @since 1.0
 */
public class LeetCodeNo42 {

    public int trap(int[] height) {
        return dp(height, height.length - 1)[height.length - 1][2];
    }

    /**
     * @param height
     * @param n
     * @return [n][当前的最大高度，当前的底线（底线一下计算过雨量，计算后需要填平），最大雨量]
     */
    private int[][] dp(int[] height, int n) {
        if (n == 0) {
            int[][] max = new int[height.length][3];
            max[0][0] = height[0];
            max[0][1] = height[0];
            max[0][2] = 0;
            return max;
        }
        int[][] max = dp(height, n - 1);
        int preH = max[n - 1][0];
        int water = max[n - 1][2];

        for (int i = n - 1; i >= 0; i--) {
            // 之前能形成凹槽的地方蓄水，蓄水后需要将凹槽填平至水位线，防止后边更高的重复计算
            if (max[i][1] < height[n] && max[i][1] < preH) {
                water += (Math.min(height[n], preH) - max[i][1]);
                max[i][1] = Math.min(height[n], preH);
            } else {
                break;
            }
        }
        max[n][0] = Math.max(height[n], max[n - 1][0]);
        max[n][1] = height[n];
        max[n][2] = water;
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new LeetCodeNo42().trap(height));
    }

}
