package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/15
 * @since 1.0
 */
public class LeetCodeNo63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] matrix = initMatrix(obstacleGrid);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(obstacleGrid[i][j] == 0){
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    private int[][] initMatrix(int[][] obstacleGrid){
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 0){
                matrix[0][i] = 1;
                continue;
            }
            break;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 0){
                matrix[i][0] = 1;
                continue;
            }
            break;
        }
        return matrix;
    }

}
