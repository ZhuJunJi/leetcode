package com.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/17
 * @since 1.0
 */
public class LeetCodeNo2103 {

    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>(rings.length()/2);
        Set<Character> pointSet = new HashSet<>();
        for (int i = 0; i < rings.length(); i+=2) {
            Character color = rings.charAt(i);
            Character num = rings.charAt(i + 1);
            if(map.containsKey(num)){
                Set<Character> colorSet = map.get(num);
                colorSet.add(color);
                if(colorSet.size() == 3){
                    pointSet.add(num);
                }
            }else {
                Set<Character> colorSet = new HashSet<Character>(3);
                colorSet.add(color);
                map.put(num,colorSet);
            }
        }

        return pointSet.size();
     }

    public static void main(String[] args) {
        System.out.println(new LeetCodeNo2103().countPoints("B0B6G0R6R0R6G9"));
    }
}
