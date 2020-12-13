package com.leetcode.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/14
 * @since 1.0
 */
public class LeetCodeNo49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

    public boolean isAnagrams(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int[] countTable = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            countTable[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if(countTable[str2.charAt(i) - 'a']-- == 0){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        LeetCodeNo49 leetCodeNo49 = new LeetCodeNo49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>list = leetCodeNo49.groupAnagrams(strs);
        System.out.println(list);
    }


}
