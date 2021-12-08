package com.leetcode.solution;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 109
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/21
 * @since 1.0
 */
public class LeetCodeNo600 {
    /**
     * 去掉高位和低位
     * 分别与 0000 0011
     *       0000 0110
     *       0000 1100
     *       0001 1000
     * 与有等于 0 的就不是
     * @param num
     * @return
     */
    public int findIntegers(int num) {
        String binaryString = Integer.toBinaryString(num);


        return 0;
    }

    public static void main(String[] args) {

        String str = Integer.toBinaryString((int)(Math.pow(10,9)));
        String str1 = Integer.toBinaryString(1);
        String str2 = Integer.toBinaryString(Integer.MAX_VALUE);
        System.out.println(str2);
    }
}





















