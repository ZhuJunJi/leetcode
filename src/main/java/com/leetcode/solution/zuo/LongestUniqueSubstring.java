package com.leetcode.solution.zuo;

import java.util.Arrays;

/**
 * 最长不重复子串
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/9
 * @since 1.0
 */
public class LongestUniqueSubstring {

    public int[] longestUniqueSubstring(String s){
        int[] res = new int[2];
        endWithCurrentCharMaxLengthSubstring(s,s.length() - 1,res);
        return res;
    }


    /**
     * 以当前字符结尾的最长子串
     * @param s
     * @param index
     * @param res
     * @return
     */
    public int endWithCurrentCharMaxLengthSubstring(String s ,int index, int[] res){
        if(index == 0){
            return 1;
        }
        int beforeLength = endWithCurrentCharMaxLengthSubstring(s,index - 1,res);
        int i;
        for (i = 1; i <= beforeLength; i++) {
            if(s.charAt(index) == s.charAt(index - i)){
                break;
            }
        }
        if(res[0] < i){
            res[0] = i;
            res[1] = index;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(1 );
        String s = "1211343516178191234512345161789";
        int[] res = new LongestUniqueSubstring().longestUniqueSubstring(s);
        System.out.println(s + "：的最长不重复字串为：" + s.substring(res[1] - res[0] + 1,res[1] + 1));
    }
}
