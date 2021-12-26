package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/13
 * @since 1.0
 */
public class LeetCodeNo304 {


    public static class NumMatrix {

        private int[][] colSum;
        private int[][] rowSum;

        public NumMatrix(int[][] matrix) {
            colSum = new int[matrix.length][matrix[0].length];
            rowSum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                colSum[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[0].length; j++) {
                    colSum[i][j] = colSum[i][j - 1] + matrix[i][j];
                }
            }

            for (int i = 0; i < matrix[0].length; i++) {
                rowSum[0][i] = matrix[0][i];
                for (int j = 1; j < matrix.length; j++) {
                    rowSum[j][i] = rowSum[j - 1][i] + matrix[j][i];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int sum = 0;
            if(row2 - row1 <= col2 - col1){
                for (int i = row1; i <= row2; i++) {
                    sum += (this.colSum[i][col2] - (col1 >= 1 ? this.colSum[i][col1 - 1] : 0));
                }
            }else {
                for (int i = col1; i <= col2; i++) {
                    sum += (this.rowSum[row2][i] - (row1 >= 1 ? this.rowSum[row1 - 1][i] : 0));
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 3;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 4;
        matrix[0][4] = 2;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 3;
        matrix[1][3] = 2;
        matrix[1][4] = 1;

        matrix[2][0] = 1;
        matrix[2][1] = 2;
        matrix[2][2] = 0;
        matrix[2][3] = 1;
        matrix[2][4] = 5;

        matrix[3][0] = 4;
        matrix[3][1] = 1;
        matrix[3][2] = 0;
        matrix[3][3] = 1;
        matrix[3][4] = 7;

        matrix[4][0] = 1;
        matrix[4][1] = 0;
        matrix[4][2] = 3;
        matrix[4][3] = 0;
        matrix[4][4] = 5;

        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));

    }
}
