package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/12
 * @since 1.0
 */
public class LeetCodeNo120 {


    public int minimumTotal1(List<List<Integer>> triangle) {
        List<List<Integer>> minimumTotalList = new ArrayList<>(triangle.size());
        List<Integer> preRow = new ArrayList<>();
        preRow.add(triangle.get(0).get(0));

        minimumTotalList.add(preRow);

        for (int y = 1; y < triangle.size(); y++) {
            List<Integer> row = triangle.get(y);
            List<Integer> minimumTotalRow = new ArrayList<>(row.size());
            for (int x = 0; x < row.size(); x++) {
                if(x == 0){
                    minimumTotalRow.add(preRow.get(x) + row.get(x));
                }else if(x > preRow.size() - 1){
                    minimumTotalRow.add(preRow.get(x - 1) + triangle.get(y).get(x));
                }else {
                    minimumTotalRow.add(Math.min(preRow.get(x),preRow.get(x - 1)) + triangle.get(y).get(x));
                }
            }
            minimumTotalList.add(minimumTotalRow);
            preRow = minimumTotalRow;
        }
        int min = preRow.get(0);

        for (int i = 1; i < preRow.size(); i++) {
            min = Math.min(min,preRow.get(i));
        }

        return min;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String,Integer> coordinateMinimumTotalMap = new HashMap<>((triangle.size() * (triangle.size() + 1) )/ 2);

        coordinateMinimumTotalMap.put(generateCoordinate(0,0),triangle.get(0).get(0));
        dp(triangle,coordinateMinimumTotalMap,triangle.size() - 1,triangle.size() - 1);

        int min = coordinateMinimumTotalMap.get(generateCoordinate(0,triangle.size() - 1));
        for (int i = 1; i < triangle.size(); i++) {
            min = Math.min(min,coordinateMinimumTotalMap.get(generateCoordinate(i,triangle.size() - 1)));
        }
        return min;
    }

    public void dp(List<List<Integer>> triangle,  Map<String,Integer> coordinateMinimumTotalMap, int x, int y){
        if(y == 0) return;
        if(x < 0) return;
        String coordinate = generateCoordinate(x,y);
        // 该坐标已经计算过
        if(coordinateMinimumTotalMap.containsKey(coordinate)) return;
        // 上 左
        dp(triangle,coordinateMinimumTotalMap,x - 1,y - 1);

        Integer minimumTotal = x - 1 < 0 ? coordinateMinimumTotalMap.get(generateCoordinate(x,y - 1)) :
                coordinateMinimumTotalMap.containsKey(generateCoordinate(x,y - 1)) ?
                Math.min(coordinateMinimumTotalMap.get(generateCoordinate(x - 1,y - 1)),coordinateMinimumTotalMap.get(generateCoordinate(x,y - 1))) :
                coordinateMinimumTotalMap.get(generateCoordinate(x - 1,y - 1));

        coordinateMinimumTotalMap.put(coordinate, minimumTotal + triangle.get(y).get(x));
        // 向左平移
        dp(triangle,coordinateMinimumTotalMap,x - 1,y);
    }

    /**
     * 生成坐标
     * @param x
     * @param y
     * @return
     */
    private String generateCoordinate(int x, int y){
        return y + "_" + x;
    }

    public static void main(String[] args) {
        // triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>(4);
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        System.out.println(new LeetCodeNo120().minimumTotal1(triangle));

    }




}
