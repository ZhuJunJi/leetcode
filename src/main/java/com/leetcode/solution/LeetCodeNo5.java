package com.leetcode.solution;

/**
 * @author zhujunji
 * @date 2020-01-12
 */
public class LeetCodeNo5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String longestPalindrome1(String s){
        if(s.length() <= 1) return s;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int begin = 0, end = 0, maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(j) != s.charAt(i)){
                    dp[j][i] = 0;
                }else {
                    // 已经挨着且相同是回文，否则 begin 向后 end 向前看是否是回文
                    dp[j][i] = i - j == 1 ? 1 :  dp[j + 1][i - 1];
                }
                // 记录最大长度
                if(dp[j][i] == 1){
                    if(maxLen < i - j + 1){
                        begin = j;
                        end = i;
                        maxLen = end - begin + 1;
                    }
                }
            }
        }

        return s.substring(begin,end + 1);
    }
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] chars = new char[2 * length + 1];

        for (int i = 0,j = 0; i < chars.length; i++) {
            chars[i] = i % 2 == 0 ? '#' : s.charAt(j++);
        }

        int[] max = new int[]{0,2,3};
        for (int i = 1; i < chars.length; i++) {
            int[] res = search(chars,i,max[2]);
            if(res[2] > max[2]){
                max = res;
            }
        }
        StringBuilder palindromeBuilder = new StringBuilder();
        for (int i = max[0]; i <= max[1]; i++) {
            if(chars[i] != '#'){
                palindromeBuilder.append(chars[i]);
            }
        }
        return palindromeBuilder.toString();
    }

    /**
     * 以 i 为中心的嘴唇回文字符串
     * @param chars
     * @param i
     * @param max 当前已经能构成的最大，优化一下性能
     */
    private int[] search(char[] chars, int i, int max){
        if(i == chars.length - 1){
            return new int[]{chars.length - 1,chars.length - 1,1};
        }
        if(i == 0){
            return new int[]{0,0,1};
        }
        int mid = (max - 1)/2;
        // 已经没有构成比现在最长更长的回文字符串的可能性了直接返回
        if(i - mid < 0 || i + mid > chars.length - 1){
            return new int[]{0,0,1};
        }
        // 先往里遍历
        for (int j = mid; j > 0; j--) {
            if(chars[i - j] != chars[i + j]){
                return new int[]{0,0,1};
            }
        }
        int[] res = new int[]{i - mid,i + mid,max};
        for (int j = mid + 1;  i - j >= 0
                && i + j <= chars.length - 1
                && chars[i - j] == chars[i + j] ; j++) {
            res[0] = i - j;
            res[1] = i + j;
            res[2] = 2 * j + 1;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(new LeetCodeNo5().longestPalindrome1("cbbd"));
    }
}
