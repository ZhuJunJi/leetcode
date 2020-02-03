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
        int midle = (nums1.length + nums2.length) / 2;
        int index1 = 0;
        int index2 = 0;
        int[] res = new int[2];
        while (index1 + index2 <= midle) {
            int temp1 = Integer.MAX_VALUE;
            int temp2 = Integer.MAX_VALUE;
            if (index1 < nums1.length) {
                temp1 = nums1[index1];
            }
            if (index2 < nums2.length) {
                temp2 = nums2[index2];
            }
            // 哪个小哪个动
            if (temp1 < temp2) {
                // 奇数偶数判断
                res[0] = res[1];
                res[1] = temp1;
                index1++;
            } else {
                res[0] = res[1];
                res[1] = temp2;
                index2++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (res[0] + res[1]) / 2;
        }
        return res[1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
