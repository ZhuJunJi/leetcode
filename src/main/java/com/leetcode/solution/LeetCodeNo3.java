package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujunji
 * @date 2019-12-22
 */
public class LeetCodeNo3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> preCharIndexMap = new HashMap<>(64);
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (preCharIndexMap.containsKey(s.charAt(end))) {
                // 如果当前字符存在map中，那么start为这两个相同字符之间最后一次出现相同字符的位置
                start = Math.max(start, preCharIndexMap.get(s.charAt(end)));
            }
            preCharIndexMap.put(s.charAt(end), end + 1);
            max = Math.max(max, end + 1 - start);
        }
        return max;

    }

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("aabaa");
        System.out.println(ans);
    }
}
