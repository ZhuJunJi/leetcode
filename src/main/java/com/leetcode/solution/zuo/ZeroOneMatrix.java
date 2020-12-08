package com.leetcode.solution.zuo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只由 0 和 1 组成的二维数组 matrix
 * 每一行都保证所有的 0 在左侧，1 在右侧
 * 那些行拥有最多的 1 加入列表返回
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/5
 * @since 1.0
 */
public class ZeroOneMatrix {


    public static List<Integer> mostOneRow(int[][] matrix){
        List<Integer> resultList = new ArrayList<>();
        if(matrix == null){
            return resultList;
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            int count = max == 0 ? 0 : max - 1;
            for (int j = arr.length - 1 - count; j >= 0; j--) {
                if(arr[j] == 1){
                    count++;
                }else {
                    // 跳出当前循环
                    break;
                }
            }

            if(count >= max && count != 0){
                if(count > max){
                    max = count;
                    resultList.clear();
                }
                resultList.add(i);
            }
        }

        return resultList;

    }
    /**Post-order traversal
     * 给定一个只由 0 和 1 组成的二维数组 matrix
     * 每一行都保证所有的 0 在左侧，1 在右侧
     * 那些行拥有最多的 1 加入列表返回
     * int[][] matrix = new int[][]{
     *                 {0,0,0,0,1,1,1,1,1},
     *                 {1,1,1,1,1,1,1,1,1},
     *                 {0,0,0,0,0,0,0,0,0},
     *                 {1,1,1,1,1,1,1,1,1},
     *                 {1,1,1,1,1,1,1,1,1}
     *         };
     * return {1,3,4}
     */
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0,0,0,0,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0},
                {},
                {0,0,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1}
        };
        System.out.println(mostOneRow(matrix));
    }
}
