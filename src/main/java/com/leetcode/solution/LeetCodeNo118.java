package com.leetcode.solution;

import java.util.ArrayList;
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
public class LeetCodeNo118 {

    public List<List<Integer>> generate(int numRows) {
        if(numRows < 1){
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        result.add(rowOne);
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i-1);
            List<Integer> rows = new ArrayList<>();
            rows.add(1);
            for (int j = 1; j < i; j++) {
                rows.add(preRow.get(j - 1) + preRow.get(j));
            }
            rows.add(1);
            result.add(rows);
        }
        return result;
    }

    public List<List<Integer>> dpGenerate(int numRows){
        if(numRows == 1) {
            List<List<Integer>> pascalsTriangle = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            row.add(1);
            pascalsTriangle.add(row);
            return pascalsTriangle;
        }
        List<List<Integer>> pascalsTriangle = dpGenerate(numRows - 1);

        List<Integer> preRow = pascalsTriangle.get(numRows - 2);

        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(preRow.get(i - 1) + preRow.get(i));
        }
        currentRow.add(1);

        pascalsTriangle.add(currentRow);

        return pascalsTriangle;
    }

    public List<Integer> getRow(int rowIndex) {
        return dpGenerate(rowIndex).get(rowIndex - 1);
    }

    public static void main(String[] args) {
        new LeetCodeNo118().generate(5);
        List<List<Integer>> pascalsTriangle = new LeetCodeNo118().dpGenerate(5);
        System.out.println(pascalsTriangle);
    }
}
