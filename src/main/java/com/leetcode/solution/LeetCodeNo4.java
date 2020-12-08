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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 由题可知 nums1 和 nums2 不可能同时为空时
        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArray(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArray(nums1);
        }
        // 保证 nums1 长度小于 nums2
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // nums1 最大的元素都小于 nums2 最小的元素，时间复杂度 O(1)
        if (nums1[nums1.length - 1] <= nums2[0]) {
            return findMedianSortedMinAndMaxArrays(nums1, nums2);
        }
        // nums2 最大的元素都小于 nums1 最小的元素，时间复杂度 O(1)
        if (nums2[nums2.length - 1] <= nums1[0]) {
            return findMedianSortedMinAndMaxArrays(nums2, nums1);
        }
        /* 如果只考虑在一个有序数组中找中位数的情况，分为两种情况
         * 当总长度偶数时将数组分为左右两部分，个数相同的两个数组。那么左边数组最大值 + 右边数组最小值就是要找的元素
         * 当总长度位奇数是将数组分位左右两部分，左边多一个元素，那么左边最大值就是要找的元素
         *
         * 所以如果满足以下条件便找到了中位数：
         * 1、条件一：分割线左边的元素最大值小于等于右边元素最小值
         * 2、条件二：在总元素个数为偶数是左右两边元素相等，总元素个数为奇数时左边元素比右边元素多一个
         * 那么中位数及总元素为奇数时就是分割线左边最大值，总元素个数为偶数时为分割线左边元素最大值和右边元素最小值的平均值
         *
         * 同理两个数组时按照分割为左右两部分的思路 m 长度的 nums1 和 n 长度的 nums2
         * 1、计算出左边元素总个数 totalLeft = (m + n + 1) >> 1
         * 1、从 nums1 开始二分找到合适的分割线 left = 0, right = m; i = left + (right - left) >> 1
         * 2、根据条件二，nums1 分割后那么 nums2 的分割线就确定的。因为左边总元素个数是一定的。 j = totalLeft - i;
         * 3、根据条件一，nums1[i] >= nums[j - 1] && nums[i - 1] <= nums2[j]
         */
        int m = nums1.length;
        int n = nums2.length;
        // 保证总长度为奇数时左边的元素个数比右边元素个数多一个，中位数就是分割后左边两个数组较大值
        int totalLeft = (m + n + 1) >> 1;
        // 在 nums1 的区间 [0, m - 1] 里查找恰当的分割线
        // 定义二分搜索区间为闭区间 [left,right] 下次搜索区间为 [left,middle - 1] or [middle + 1, right]
        int left = 0;
        int right = m - 1;
        // 因为搜索区间为闭区间，所以循环条件包含等于，只有当 left > right 时停止循环
        while (left <= right) {
            // nums1 左边的元素个数
            // 防止越界 将 (right + left) / 2 改写为如下等价表达式
            int i = left + ((right - left) >> 1);
            // nums2 左边的元素个数
            int j = totalLeft - i;
            // 因为保持的是 nums2 比 nums1 长
            // 所以 nums1.length < nums1.length + nums2.length && nums2.length > nums1.length + nums2.length
            // 所以 nums2 左边肯定有元素且 nums2[j] 不可能越界
            if (nums1[i] < nums2[j - 1]) {
                // nums1 左边个数少了，缩小左边界
                left = i + 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                right = i - 1;
            }
        }
        int i = left;
        // nums2 左边的元素个数
        int j = totalLeft - i;
        if (((m + n) % 2) == 0){
            // 总长度为偶数
            if(i >= m){
                return (Math.max(nums1[i - 1],nums2[j - 1]) + nums2[j]) / 2D;
            }else if(i < 1){
                return (nums2[j - 1] + Math.min(nums1[i],nums2[j])) / 2D;
            }else {
                return (Math.max(nums1[i - 1],nums2[j - 1]) + Math.min(nums1[i],nums2[j])) / 2D;
            }
        }else {
            // 总长度为奇数，最表较大值就是中位数
            return i < 1 ? nums2[j - 1] : Math.max(nums1[i - 1],nums2[j - 1]);
        }
    }

    /**
     * 寻找两个有序数组中第 K 小的数
     *
     * @param nums1 有序数组1
     * @param nums2 有序数组2
     * @param k     第K小
     * @return Integer  nums1 和 nums2 中第 K 小的数
     */
    public int getTheKMinNumberSortedArrays(int[] nums1, int[] nums2, int k) {
        int len = nums1.length + nums2.length;
        // 两个数组都以 (k + 1) >> 1 分割
        // 1、保证 nums1[m] 小于 nums2[n + 1]，同理保证 nums2[n] < nums1[m + 1]
        // 2、保证左边多一个元素，当总长度 len 为奇数时，第 K 小元素就是分割线左边较大值
        return 0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 由题可知 nums1 和 nums2 不可能同时为空
        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArray(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArray(nums1);
        }
        // nums1 最大的元素都小于 nums2 最小的元素
        if (nums1[nums1.length - 1] <= nums2[0]) {
            return findMedianSortedMinAndMaxArrays(nums1, nums2);
        }
        // nums2 最大的元素都小于 nums1 最小的元素
        if (nums2[nums2.length - 1] <= nums1[0]) {
            return findMedianSortedMinAndMaxArrays(nums2, nums1);
        }

        int len = nums1.length + nums2.length;
        int medianPre = 0;
        int median = 0;
        for (int indexA = 0, indexB = 0; indexA + indexB <= len >> 1; ) {
            medianPre = median;
            if (indexA >= nums1.length) {
                median = nums2[indexB++];
            } else if (indexB >= nums2.length) {
                median = nums1[indexA++];
            } else if (nums1[indexA] < nums2[indexB]) {
                median = nums1[indexA++];
            } else {
                median = nums2[indexB++];
            }
        }
        return len % 2 == 0 ? (medianPre + median) / 2D : median;
    }

    /**
     * minNums 最大的元素都小于 maxNums 最小的元素
     *
     * @param minNums
     * @param maxNums
     * @return
     */
    public double findMedianSortedMinAndMaxArrays(int[] minNums, int[] maxNums) {
        int len = minNums.length + maxNums.length;
        int middle = len >> 1;
        if (len % 2 == 0) {
            // 偶数 middle middle - 1
            if (middle == minNums.length) {
                // 中位数位 minNums 的最大值 和 maxNums 最小值
                return (minNums[minNums.length - 1] + maxNums[0]) / 2D;
            } else if (middle - 1 > minNums.length - 1) {
                // 中位数位都在maxNums
                return (maxNums[middle - minNums.length - 1] + maxNums[middle - minNums.length]) / 2D;
            } else {
                // 中位数位都在minNums
                return (minNums[middle - 1] + minNums[middle]) / 2D;
            }
        } else {
            if (middle > minNums.length - 1) {
                return maxNums[middle - minNums.length];
            } else {
                return minNums[middle];
            }
        }
    }

    /**
     * 获取非空数组中位数
     *
     * @param nums
     * @return
     */
    public double findMedianSortedArray(int[] nums) {
        int median = nums.length >> 1;
        if (nums.length % 2 == 0) {
            return (nums[median] + nums[median - 1]) / 2D;
        } else {
            return nums[median];
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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

    /**
     * 二分查找返回第一个找到的数
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 搜索区间 [left, right) 二分搜索区间为 [left,middle) [middle + 1,right)
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (right + left) >> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                // 中位数大于 target 搜索区间改为 [left,middle)
                right = middle;
            } else if (nums[middle] < target) {
                // 中位数小于 target 搜索区间改为 [middle + 1,right)
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 搜索区间 [left, right) 二分搜索区间为 [left,middle) [middle + 1,right)
        int left = 0;
        int right = nums.length;
        while (left < right) {
            // middle = (right + left) / 2 此写法当 right + left > Integer.MAX_VALUE 时有问题
            // 改为如下等价表达式 left + (right - left) / 2
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                // 因为寻找右边界，所以继续缩小左边界
                left = middle + 1;
            } else if (nums[middle] > target) {
                // 中位数大于 target 搜索区间改为 [left,middle)
                right = middle;
            } else if (nums[middle] < target) {
                // 中位数小于 target 搜索区间改为 [middle + 1,right)
                left = middle + 1;
            }
        }
        if (right == 0) {
            return -1;
        }
        // 找到后指针向后移动了一位，所以判断循环结束后的前一位是否与 target 相等，不相等没找到
        return nums[right - 1] == target ? right - 1 : -1;
    }

    /**
     * 二分查找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 定义搜索区间为 [left,right] 所以下次搜索的区间为 [middle + 1,right] 或者 [left,middle - 1]
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为闭区间，所以终止条件为 left > right
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                // 因为找的是左边界所以缩小右区间
                right = middle - 1;
            } else if (nums[middle] > target) {
                // 缩小右区间
                right = middle - 1;
            } else if (nums[middle] < target) {
                // 缩小左区间
                left = middle + 1;
            }
        }
        // 因为搜索的是左区间，所以循环结束后结果为 left - 1
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }
}
