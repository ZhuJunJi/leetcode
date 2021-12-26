package com.leetcode.solution;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/9
 * @since 1.0
 */
public class LeetCodeNo91 {

    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        return dp(s.toCharArray(),s.length() - 1)[s.length() - 1][1];
    }

    /**
     *[能否解码，最大组合]
     */
    public int[][] dp(char[] chars, int n){
        if(n == 0) {
            int[][] decodings = new int[chars.length][2];
            decodings[0][0] = 1;
            decodings[0][1] = 1;
            return decodings;
        }
        int[][] decodings = dp(chars, n - 1);
        if(decodings[n - 1][0] == 0){
            decodings[n][0] = 0;
            decodings[n][1] = 0;
            return decodings;
        }
        boolean decodeWithBefore = canDecoding(chars[n - 1], chars[n]);
        if(chars[n] == '0'){
            decodings[n][0] = decodeWithBefore ? 1 : 0;
            decodings[n][1] = decodeWithBefore ? (n >= 2 ? decodings[n - 2][1] : 1) : 0;
        }else {
            decodings[n][0] = 1;
            decodings[n][1] = decodeWithBefore ? decodings[n - 1][1] + (n >= 2 ? decodings[n - 2][1] : 1) : decodings[n - 1][1];
        }
        return decodings;
    }

    public boolean canDecoding(char a, char b){
        if(a == '0') return false;
        if(a > '3') return false;
        if(a == '1') return true;
        if(a == '2' && b <= '6') return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "11111110";
        System.out.println(new LeetCodeNo91().numDecodings(s));
    }

}
