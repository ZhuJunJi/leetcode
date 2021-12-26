package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/15
 * @since 1.0
 */
public class LeetCodeNo62 {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        dp(matrix,m - 1,n - 1);

        return matrix[m - 1][n - 1];
    }


    private void  dp(int[][] matrix,int m, int n){
        if(n == 0){
            matrix[m][n] = 1;
            return;
        }
        if(m == 0){
            matrix[0][n] = 1;
            return;
        }
        if(matrix[m][n] != 0){
            return;
        }
        // 上
        dp(matrix,m - 1, n);
        // 左
        dp(matrix, m, n - 1);

        matrix[m][n] = matrix[m - 1][n] + matrix[m][n - 1];
    }

}
