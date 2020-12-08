package com.leetcode.solution.zuo;

/**
 * @author zhujunji <zhujunji90s@gmail.com>
 * @version V1.0.0
 * @date 2020/12/6
 * @since 1.0
 */
public class EqualProbabilityRandom {

    public static class RandomBox{

        private final double p;

        public RandomBox(double p) {
            this.p = p;
        }

        public int random(){
            return Math.random() < p ? 0 : 1;
        }
    }

    /**
     * RandomBox 以指定概率 P 返回 0，1 - P 概率 返回 1
     * 请利用 RandomBox 实现一个等概率获取 0 1 的函数
     * @param randomBox
     * @return
     */
    public static int rendom(RandomBox randomBox){
        int num = -1;
        while (num == -1){
            int r1 = randomBox.random();
            int r2 = randomBox.random();
            num = r1 == r2 ? -1 : r1 > r2 ? 1 : 0;
        }
        return num;
    }


    public static void main(String[] args) {
        int count0 = 0;
        int count1 = 0;
        RandomBox randomBox = new RandomBox(0.1);
        for (int i = 0; i < 1000000; i++) {
            int random = rendom(randomBox);
            if(random == 0){
                count0++;
            }
            if(random == 1){
                count1++;
            }
        }
        System.out.println("0:"+count0+" 1:"+count1);
    }
}
