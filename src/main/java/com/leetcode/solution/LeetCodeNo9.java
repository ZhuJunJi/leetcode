package com.leetcode.solution;

import java.util.Stack;

/**
 * @author zhujunji
 * @date 2020-01-14
 */
public class LeetCodeNo9 {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(int x) {
        // 示例2看样子只要是负数有个符号就不可能是回文了
        // (x % 10 == 0 && x != 0) 除了0以外 10的倍数的数排除掉了
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        // 用到了第7题的求一个数的倒数
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // （rev == x）偶数长度，（rev / 10 == x） 奇数长度
        return rev == x || rev / 10 == x;
    }
}
