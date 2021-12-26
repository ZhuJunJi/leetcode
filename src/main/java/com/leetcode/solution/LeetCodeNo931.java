package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/12
 * @since 1.0
 */
public class LeetCodeNo931 {

    public int minFallingPathSum(int[][] matrix) {
        int[][] minStep = new int[matrix.length][matrix.length];

        boolean[][] dp = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            minStep[0][i] = matrix[0][i];
            dp[0][i] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            dp(matrix, minStep, dp, i, matrix.length - 1);
        }

        int min = minStep[matrix.length - 1][0];

        for (int i = 1; i < matrix.length; i++) {
            min = Math.min(minStep[matrix.length - 1][i], min);
        }
        return min;
    }

    /**
     *
     */
    public void dp(int[][] matrix, int[][] minStep, boolean[][] dp, int x, int y) {
        if (y == 0) return;
        if (x < 0 || x > matrix.length - 1) return;
        if (dp[y][x]) return;

        // 向上
        dp(matrix, minStep, dp, x, y - 1);
        dp(matrix, minStep, dp, x + 1, y - 1);
        dp(matrix, minStep, dp, x - 1, y - 1);

        // 上 右 选较小值
        minStep[y][x] = (x == matrix.length - 1) ? minStep[y - 1][x] : Math.min(minStep[y - 1][x], minStep[y - 1][x + 1]);
        // 上 左 选较小值
        minStep[y][x] = (x == 0) ? minStep[y][x] : Math.min(minStep[y][x], minStep[y - 1][x - 1]);

        minStep[y][x] += matrix[y][x];
        dp[y][x] = true;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[0][0] = 2;
//        matrix[0][1] = 1;
//        matrix[0][2] = 3;
//        matrix[1][0] = 6;
//        matrix[1][1] = 5;
//        matrix[1][2] = 4;
//        matrix[2][0] = 7;
//        matrix[2][1] = 8;
//        matrix[2][2] = 9;
        int[][] matrix = new int[2][2];
        matrix[0][0] = 17;
        matrix[0][1] = 82;
        matrix[1][0] = 1;
        matrix[1][1] = -44;
        System.out.println(new LeetCodeNo931().minFallingPathSum(matrix));
    }
}
