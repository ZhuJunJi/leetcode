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
    public static String longestPalindrome(String s) {
        String tempStr = preProcess(s);
        // 中心探索
        int max = 0;
        String palindrome = "";
        for (int i = 1; i < tempStr.length(); i++) {
            // 中心探索
            int length = 1;
            for (int j = i -1,k = i + 1;j >= 0 && k < tempStr.length();j--,k++){
                if(tempStr.charAt(j) == tempStr.charAt(k)){
                    length += 2;
                    if(length > max){
                        max = Math.max(max,length);
                        palindrome = tempStr.substring(j,k+1);
                    }
                }else {
                    break;
                }
            }
        }
        return palindrome.replaceAll("#","");
    }

    public static String preProcess(String s){
        StringBuffer buffer = new StringBuffer();
        int len = s.length();
        buffer.append('#');
        for(int i = 0; i < len; i++) {
            buffer.append(s.charAt(i));
            buffer.append('#');
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
