package com.leetcode.solution;

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
    public static int reverse(int x) {
        // 自己做得差劲
        String xStr = String.valueOf(x);
        String signBit = "";
        if (x < 0) {
            signBit = "-";
            xStr = xStr.replaceAll(signBit, "");
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(signBit);
        for (int i = xStr.length() - 1; i >= 0; i--) {
            buffer.append(xStr.charAt(i));
        }
        long result = Long.parseLong(buffer.toString());
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static int reverseFast(int x) {
        // 大佬做得牛逼
        int reverse = 0;
        int temp = x;
        boolean negative = x < 0;
        if (negative) {
            temp = -temp;
        }
        // 整数每次取模10得到个位数，再除以10循环
        while (temp > 0) {
            int singles = temp % 10;
            temp /= 10;
            if (reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + singles;
        }
        return negative ? -reverse : reverse;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-2147483642));
    }
}
