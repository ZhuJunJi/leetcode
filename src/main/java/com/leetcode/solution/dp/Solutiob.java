package com.leetcode.solution.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2021/12/1
 * @since 1.0
 */
class Solution {

    private static Map<Integer,Integer> cache = new HashMap<>();

    static{
        cache.put(0,0);
        cache.put(1,1);
    }

    public int fib(int n) {
        if(n <= 1) return n;

        int fib = cache.containsKey(n - 1) ? cache.get(n - 1) : fib(n - 1);
        fib += cache.containsKey(n - 2) ? cache.get(n - 2) : fib(n - 2);

        cache.put(n,fib);
        return fib;
    }
}