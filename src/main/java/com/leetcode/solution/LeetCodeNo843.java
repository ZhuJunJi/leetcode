package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/8
 * @since 1.0
 */
public class LeetCodeNo843 {

    /**
     * 定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     * <p>
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     * <p>
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     * <p>
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> fibonacciList = new ArrayList<>();

        backtrack(S.toCharArray(), fibonacciList, 0);
        return fibonacciList;
    }

    /**
     * 回溯
     *
     * @param digit
     * @param res
     * @param index
     * @return
     */
    private boolean backtrack(char[] digit, List<Integer> res, int index) {
        // index == length 如果 res 还没有 3 个以上元素及没有斐波那契数列
        if (index == digit.length) {
            return res.size() >= 3;
        }

        for (int i = index; i < digit.length; i++) {
            // i == index 时就是一位数
            // 两位及以上数不能以 0 开头
            if (digit[index] == '0' && i > index) {
                return false;
            }
            long num = sumDigit(digit, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            // 如果已经大于前两个数就没必要继续了
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) {
                return false;
            }
            // res 没有元素或者 1 个元素时，或者有 2 个及以上元素且符合斐波那契数列时，将元素加入 res
            if (res.size() <= 1 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                // 加入当前元素
                res.add((int) num);
                if (backtrack(digit, res, i + 1)) {
                    return true;
                }
                // 删除当前添加元素，重复当前步骤
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    private long sumDigit(char[] digit, int start, int end) {
        long num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + digit[i] - '0';
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "01123";
        System.out.println(new LeetCodeNo843().splitIntoFibonacci(s));
    }


}
