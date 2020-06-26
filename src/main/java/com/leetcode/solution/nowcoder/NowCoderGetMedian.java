package com.leetcode.solution.nowcoder;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhujunji
 */
public class NowCoderGetMedian {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     *
     * @param num
     * @return
     */

    private ArrayList<Integer> numberList = new ArrayList<>();

    public void Insert(Integer num) {
        int i = 0;
        for(; i < numberList.size(); i++){
            if(num <= numberList.get(i)){
                break;
            }
        }
        numberList.add(i,num);
    }

    public Double GetMedian() {
        if(numberList.size() == 0){
            return null;
        }
        int medianIndex = numberList.size() >> 1;
        if(numberList.size() % 2 == 0){
            return (numberList.get(medianIndex) + numberList.get(medianIndex - 1)) / 2D;
        }else{
            return Double.valueOf(numberList.get(medianIndex));
        }
    }

    @Test
    public void test() {
        NowCoderGetMedian nowCoderGetMedian = new NowCoderGetMedian();
        nowCoderGetMedian.Insert(5);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(2);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(3);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(4);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(1);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(6);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(7);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(0);
        System.out.println(nowCoderGetMedian.GetMedian());
        nowCoderGetMedian.Insert(8);
        System.out.println(nowCoderGetMedian.GetMedian());
//        nowCoderGetMedian.Insert(7);

    }

}
