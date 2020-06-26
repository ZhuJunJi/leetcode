package com.leetcode.solution;

import org.junit.Test;

/**
 * @author zhujunji
 * @date 2020-01-13
 */
public class LeetCodeNo7 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverse(int x) {
        boolean negative = x < 0;
        if(negative){
            // x = -2147483648 时 -x = 2147483648 超出 Integer.MAX_VALUE 最大值还是为负数
            // 所以 while 循环的条件是 x > 0 不能是 x != 0
            x = -x;
        }
        int reverse = 0;
        while (x > 0){
            if(reverse > Integer.MAX_VALUE / 10){
                return 0;
            }
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return negative ? -reverse : reverse;
    }

    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-2147483648));
    }
}
