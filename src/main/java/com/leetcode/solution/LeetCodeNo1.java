package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujunji
 * @date 2019-12-22
 */
public class LeetCodeNo1 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果map中有target-nums[i]找到答案
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + nums[i];
            } else if (nums[i] == pre + 1) {
                // 相邻
                pre = nums[i];
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + nums[i];
            } else {
                // 不相邻
                pre = nums[i];
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) return word;
        }
        return "";
    }


    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String addSpaces(String s, int[] spaces) {
        char[] chars = new char[s.length() + spaces.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (p1 < spaces.length && spaces[p1] == p2) {
                chars[i] = ' ';
                p1++;
            } else {
                chars[i] = s.charAt(p2);
                p2++;
            }
        }
        return new String(chars);
    }


    public static long getDescentPeriods(int[] prices) {
        if (prices.length == 1) return 1;
        long sum = 0;
        long count = 1;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == pre - 1) {
                count++;
            } else {
                sum += ((count + 1) * count) / 2;
                count = 1;
            }
            pre = prices[i];
        }
        sum += ((count + 1) * count) / 2;
        return sum;
    }






}
