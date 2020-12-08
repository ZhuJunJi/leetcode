package com.leetcode.solution.zuo;

import java.util.HashMap;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/5
 * @since 1.0
 */
public class WaterKing {


    public static int findWaterKingNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if(arr.length == 1){
            return arr[0];
        }

        int half = arr.length >> 1;

        // 候选
        int candidate = 0;
        // 血量
        int hp = 0;

        for (int num : arr) {

            if (hp == 0) {
                // 血量为 0  当前数列为候选，设置 1 点血量
                candidate = num;
                hp++;
            } else if (candidate == num) {
                // 当前数和候选相同，血量 + 1
                hp++;
                if (hp > half) {
                    // 血量已经过半，返回结果
                    return num;
                }
            } else {
                // 与候选值不同，血量 -1
                hp--;
            }

        }
        if (hp == 0) {
            return -1;
        }
        hp = 0;
        for (int value : arr) {
            if (value == candidate) {
                hp++;
            }
        }
        return hp <= (arr.length >> 1) ? -1 : candidate;
    }

    public static int waterKing(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if(arr.length == 1){
            return arr[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        int half = arr.length >> 1;
        for (int value : arr) {
            if (map.containsKey(value)) {
                int count = map.get(value) + 1;
                if(count > half){
                    return value;
                }
                map.put(value, count);
            } else {
                map.put(value, 1);
            }

        }
        return -1;
    }

    public static int[] randomArray(int maxLen, int range) {
        // 随机一个非负数，作为测试数组的长度
        int len = (int) (Math.random() * (maxLen + 1));
        int[] arr = new int[len];
        if (len == 0) {
            return arr;
        }
        // 50%的概率决定：随机选择一个数，安排其成为测试数据中的水王数
        // 剩下50%的概率：不人为干预，完全随机的生成测试数据
        boolean hasWaterKing = Math.random() < 0.5;
        if (hasWaterKing) { // 人为干预，一定在测试数据中存在某个数是水王数
            int waterKing = randomNumber(range);
            int index = 0;
            // 如果数组长度为N，往数组中人为放入>N/2个水王数
            for (; index < ((len + 2) >> 1); index++) {
                arr[index] = waterKing;
            }
            // 数组剩下的位置，填入随机数
            for (; index < len; index++) {
                arr[index] = randomNumber(range);
            }
            // 把数字的出现规律打乱
            for (index = len - 1; index >= 0; index--) {
                // 随机选出一个[0,index]范围上的位置
                int randomIndex = (int) (Math.random() * (index + 1));
                // 把inde位置和randomIndex位置上的数字做交换
                int tmp = arr[index];
                arr[index] = arr[randomIndex];
                arr[randomIndex] = tmp;
            }
        } else { // 不人为干预，完全随机的生成测试数据
            for (int i = 0; i < arr.length; i++) {
                arr[i] = randomNumber(range);
            }
        }
        return arr;
    }

    // 如果输入参数是5
    // 那么将返回-5~+5范围上的数
    // 但在这个范围上返回的数，并不是等概率的
    // 因为等不等概率对这个测试来说不是特别重要
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }


    // 用两种方法来做验证
    // 如果verify方法和waterKing方法每次返回的结果一样
    // 说明两个方法都正确
    public static void main(String[] args) {
        int maxLen = 1000;
        int maxValue = 5;
        int testTime = 100000;
        System.out.println("如果没有打印错误，说明验证通过");
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans1 = findWaterKingNumber(arr);
            int ans2 = waterKing(arr);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }

}
