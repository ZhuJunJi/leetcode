package com.leetcode.solution;

/**
 * @author zhujunji
 * @date 2020-01-12
 */
public class LeetCodeNo4 {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length - 1, n = nums2.length - 1;
        int median = (nums1.length + nums2.length) / 2 + 1;
        int temp = 0;
        int x = 0;
        while (true) {
            int numberM = Integer.MIN_VALUE;
            int numberN = Integer.MIN_VALUE;
            if (m >= 0) {
                numberM = nums1[m];
            }
            if (n >= 0) {
                numberN = nums2[n];
            }
            if (numberM >= numberN) {
                m--;
            } else {
                n--;
            }
            x++;
            if (x == median) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    // 偶数中位数为 (m + n)/2 和 (m + n)/2 + 1 合除以2
                    return (double) (temp + Math.max(numberM, numberN)) / 2;
                } else {
                    return Math.max(numberM, numberN);
                }
            }
            temp = Math.max(numberM, numberN);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
