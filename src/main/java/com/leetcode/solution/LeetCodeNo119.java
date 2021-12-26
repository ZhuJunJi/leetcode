package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 杨辉三角
 * 输入: 5
 * 输出:
 * [
 *  [1],
 *  [1,1],
 *  [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/6
 * @since 1.0
 */
public class LeetCodeNo119 {

    public void dpGenerate(int numRows, Integer[] row){
        if(numRows == 1) return;

        dpGenerate(numRows - 1, row);

        int temp = row[0];
        for (int i = 1; i < numRows - 1; i++) {
            int pre = row[i];
            row[i] = temp + pre;
            temp = pre;
        }
        row[numRows - 1] = 1;
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        row[rowIndex] = 1;
        dpGenerate(rowIndex + 1, row);
        return Arrays.asList(row);
    }

    public static void main(String[] args) {
        List<Integer> pascalsTriangle = new LeetCodeNo119().getRow(5);
        System.out.println(pascalsTriangle);
    }
}
