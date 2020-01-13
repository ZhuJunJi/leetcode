package com.leetcode.solution;
/**
 * @author zhujunji
 * @date 2020-01-13
 */
public class LeetCodeNo6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String convert(String s, int numRows) {
        if (s == null || numRows == 1 || s.length() < numRows) {
            return s;
        }
        int len = s.length();
        // 求得X轴的长度
        int a = (len - 1) / (2 * (numRows - 1));
        int b = (len - 1) % (2 * (numRows - 1));
        int c = Math.max(b - numRows + 1, 0);
        // 根据规律求得x轴的长度
        int x = a * (numRows - 1) + 1 + c;
        // 定义二位数组
        char[][] arr = new char[numRows][x];
        arr[numRows - 1][0] = s.charAt(0);
        boolean flag = false;
        int count = 0;
        // Z字形填充二维数组
        for (int i = 1, j = 0, k = numRows - 2; i < len; i++) {
            count++;
            // 每（numRows - 1）周期改变一次y轴的方向
            if (count == numRows - 1) {
                count = 0;
                flag = !flag;
            }
            arr[k][j] = s.charAt(i);
            if (flag) {
                // x轴递增、y递增
                j++;
                k++;
            } else {
                // x不变、y递减
                k--;
            }
        }
        // 遍历得到结果
        StringBuffer buffer = new StringBuffer();

        for (int j = numRows - 1; j >= 0; j--) {
            for (int i = 0; i < x; i++) {
                if (arr[j][i] != '\u0000') {
                    buffer.append(arr[j][i]);
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String leetCodeStr = "LEETCODEISHIRING";
        System.out.println(convert(leetCodeStr, 4));
    }
}
