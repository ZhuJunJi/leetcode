package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/15
 * @since 1.0
 */
public class LeetCodeNo64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];

        dp(matrix,grid,m - 1, n - 1);
        return matrix[m- 1][n- 1];
    }

    private void dp(int[][] matrix, int[][] grid, int m, int n) {
        if(m == 0 && n == 0){
            matrix[0][0] = grid[0][0];
            return;
        }
        if(matrix[m][n] != 0) return;
        // 第一列
        if(m == 0){
            dp(matrix,grid,m,n - 1);
            matrix[0][n] = matrix[0][n - 1] + grid[0][n];
            return;
        }
        if(n == 0){
            dp(matrix,grid,m - 1,n);
            matrix[m][0] = matrix[m - 1][0] + grid[m][0];
            return;
        }
        dp(matrix,grid,m,n - 1);
        dp(matrix,grid,m - 1,n);
        matrix[m][n] = grid[m][n] + Math.min(matrix[m][n - 1],matrix[m - 1][n]);
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];

        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;

        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;

        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(new LeetCodeNo64().minPathSum(grid));
    }


}
