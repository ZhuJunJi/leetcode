package com.leetcode.solution.zuo;

/**
 *
 * str = a，a，b，b，c  aim = bc
 * aim 建立资产负载表
 * b=1
 * c=1
 * str 先去 aim 长度的字符还款
 *
 *
 *
 *
 *
 *
 * 同质量异构：例如   abc 和 bac 为同质异构 字符串中所有的元素个数相同为同质异构
 * 如果 字符串 str 中 存在与 aim 同质异构的子串，返回索引
 * 例如：srt = abc aim = bc
 *
 * acb bc
 *
 * return 1
 *
 * 票1 票2 票3 票4 票5
 * 1   2   3   2  2
 * 你有个机器可以对比票1 和票2 一样还是不一样，你看不到票真正投给谁 1 2 3 2 2 你不可见
 * 成立 任意翻出一张是2 的选票公布出来就ok
 *
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/6
 * @since 1.0
 */
public class StringContainExactlyAim {

    public static int containExactly2(String str, String aim){
        if (str == null || aim == null || str.length() < aim.length()) {
            return -1;
        }
        int m = aim.length();
        // 建立资产负载表
        int[] assetLoadTable = new int[256];
        // 无效还款
        int invalidRepayment = 0;
        int R = 0;
        for (; R < aim.length(); R++) {
            // 负载 + 1
            assetLoadTable[aim.charAt(R)]++;
        }
        // 先还一次款
        for (R = 0; R < aim.length(); R++){
            if(assetLoadTable[str.charAt(R)]-- <= 0){
                // 过度还款，无效还款 + 1
                invalidRepayment++;
            }
        }
        if(invalidRepayment == 0){
            return 0;
        }
        for (; R < str.length(); R++){
            // 窗口右边还款，无效还款时，无效还款 + 1
            if(assetLoadTable[str.charAt(R)]-- <= 0){
                invalidRepayment++;
            }
            // 窗口左边归还已还贷款，归还成功无效还款 - 1
            if(assetLoadTable[str.charAt(R - aim.length())]++ < 0){
                invalidRepayment--;
            }
            if(invalidRepayment == 0){
                return R - aim.length();
            }

        }
        return -1;
    }

    public static int containExactly(String str, String aim) {
        if (str == null || aim == null || str.length() < aim.length()) {
            return -1;
        }
        for (int i = 0; i <= str.length() - aim.length(); i++) {
            if(isSeam(str,i,aim)){
                // -1 代表找到了
                return i;
            }
        }
        return -1;

    }

    /**
     * str 的 start 开始 aim 长度的字符串与 aim 是否同源异构
     * 如果是返回 -1
     * 如果不是 返回 start 开始后第一个不在 aim 中存在的字符串的下标
     * @param str
     * @param start
     * @param aim
     * @return
     */
    public static boolean isSeam(String str, int start, String aim){
        if(str.length() - start < aim.length()){
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < aim.length(); i++) {
            count[aim.charAt(i)]++;
        }
        for (int i = 0; i < aim.length(); i++) {
            if(count[str.charAt(start + i)]-- == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aaabbabb";
        String arim = "ababa";
        System.out.println(containExactly(str,arim));
    }
}
