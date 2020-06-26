package com.leetcode.solution.nowcoder;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author zhujunji
 */
public class NowCoderCutRope {
    /**
     * 题目描述
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 输入描述:
     * 输入一个数n，意义见题面。（2 <= n <= 60）
     *
     * @param target
     * @return
     */

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        HashMap<Integer, Integer> resultCache = new HashMap<>(target);

        return backTrack(target, resultCache);
    }

    public int backTrack(int n, HashMap<Integer, Integer> resultCache) {
        if (n <= 4) {
            return n;
        }
        if (resultCache.containsKey(n)) {
            return resultCache.get(n);
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, i * backTrack(n - i, resultCache));
        }
        resultCache.put(n, result);
        return result;
    }


    @Test
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println(cutRope1(60));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    public int cutRope1(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] max = new int[target + 1];
        for (int i = 1; i <= 4; i++) {
            max[i] = i;
        }
        for (int i = 5; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                max[i] = Math.max(max[i], j * max[i - j]);
            }
        }
        return max[target];
    }
}
