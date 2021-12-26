package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/13
 * @since 1.0
 */
public class LeetCodeNo1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int[][] answer = new int[mat.length][mat[0].length];
        int[][] colSum = colSum(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                answer[i][j] = sum(mat,colSum,i - k,j - k, i + k, j + k);
            }
        }
        return answer;
    }

    public int sum(int[][] mat, int[][] colSum, int row1, int col1, int row2, int col2){
        row1 = row1 < 0 ? 0 : row1;
        row2 = row2 > mat.length - 1 ? mat.length - 1 : row2;
        col1 = col1 < 0 ? 0 : col1;
        col2 = col2 > mat[0].length - 1 ? mat[0].length - 1 : col2;
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += (colSum[i][col2] - (col1 >= 1 ? colSum[i][col1 - 1] : 0));
        }
        return sum;
    }

    public int[][] colSum(int[][] matrix){
        int[][] colSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            colSum[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                colSum[i][j] = colSum[i][j - 1] + matrix[i][j];
            }
        }
        return colSum;
    }

    public int[][] rowSum(int[][] matrix){
        int[][] rowSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            rowSum[0][i] = matrix[0][i];
            for (int j = 1; j < matrix.length; j++) {
                rowSum[j][i] = rowSum[j - 1][i] + matrix[j][i];
            }
        }
        return rowSum;
    }

}
