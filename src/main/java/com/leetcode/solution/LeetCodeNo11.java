package com.leetcode.solution;

public class LeetCodeNo11 {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */
    public int maxArea(int[] height) {
        // O(n^2)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i],height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针
     */
    public int maxAreaDoublePointer(int[] height) {
        // O(n)
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            // 高度低的一边移动
            if(height[left] < height[right]){
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }
}
