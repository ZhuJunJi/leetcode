package com.leetcode.solution;


import java.util.Stack;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/18
 * @since 1.0
 */
public class LeetCodeNo392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        int[][] dp = initDP(t);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(dp[j][s.charAt(i) - 'a'] == t.length()){
                return false;
            }else {
                j = dp[j][s.charAt(i) - 'a'] + 1;
            }
        }
        return true;
    }

    private int[][] initDP(String t){
        int[][] dp = new int[t.length() + 1][26];
        for (int i = 0; i <= 25; i++) {
            dp[t.length()][i] = t.length();
        }
        for(int i = t.length() - 1; i >= 0; i--){
            int index = t.charAt(i) - 'a';
            for(int j = 0; j <= 25; j++){
                if(j == index){
                    dp[i][j] = i;
                }else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCodeNo392().isSubsequence("bba","bbaaaa"));
    }

}
