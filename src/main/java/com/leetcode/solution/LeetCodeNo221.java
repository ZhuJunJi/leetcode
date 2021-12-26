package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/15
 * @since 1.0
 */
public class LeetCodeNo221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rowSum = new int[m][n];


        for (int i = 0; i < matrix[0].length; i++) {
            rowSum[0][i] = matrix[0][i] - 48;
            for (int j = 1; j < matrix.length; j++) {
                rowSum[j][i] = rowSum[j - 1][i] + matrix[j][i] - 48;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //
                if(max > Math.pow(Math.min(m - i, n -j),2)){
                    continue;
                }

                max = Math.max(sumMatrix(matrix, rowSum, i, j), max);
            }
        }
        return max;
    }

    /**
     * 通过求和判断正方形大小
     *
     * @param rowSum
     * @param m
     * @param n
     * @return
     */
    public int sumMatrix(char[][] matrix, int[][] rowSum, int m, int n) {
        if(matrix[m][n] == '0'){
            return 0;
        }
        int max = 0;
        for (int i = 0; i <= Math.min(matrix.length - m - 1,matrix[0].length - n - 1); i++) {
            // m + 1, n + 1
            int sum = sum(rowSum, m, n,m + i,n + i);
            if(sum == Math.pow(i+1,2)){
                max = Math.max(max,sum);
            }else {
                break;
            }
        }

        return max;
    }

    private int sum(int[][] rowSum, int row1, int col1, int row2, int col2){
        int sum = 0;
        for (int i = col1; i <= col2; i++) {
            sum += (rowSum[row2][i] - (row1 >= 1 ? rowSum[row1 - 1][i] : 0));
        }
        return sum;
    }


    public static void main(String[] args) {

        char[][] matrix = new char[4][5];

        matrix[0][0] = '1';
        matrix[0][1] = '0';
        matrix[0][2] = '1';
        matrix[0][3] = '0';
        matrix[0][4] = '0';

        matrix[1][0] = '1';
        matrix[1][1] = '0';
        matrix[1][2] = '1';
        matrix[1][3] = '1';
        matrix[1][4] = '1';

        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '1';
        matrix[2][3] = '1';
        matrix[2][4] = '1';

        matrix[3][0] = '1';
        matrix[3][1] = '0';
        matrix[3][2] = '0';
        matrix[3][3] = '1';
        matrix[3][4] = '0';

        char[][] matrix2 = new char[2][2];
        matrix2[0][0] = '0';
        matrix2[0][1] = '1';
        matrix2[1][0] = '1';
        matrix2[1][1] = '0';

        System.out.println(new LeetCodeNo221().maximalSquare(matrix));
    }

}
