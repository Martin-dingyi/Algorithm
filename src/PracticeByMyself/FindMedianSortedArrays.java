package PracticeByMyself;

import java.util.Arrays;
// 寻找两个正序数组的中位数
// https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?envType=study-plan-v2&envId=top-interview-150

// 这题的难点不是算法思想和数学证明，而是coding能力。
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        return (double) (getKthSmallestNum(nums1, 0, n - 1, nums2, 0, m - 1, (n + m + 1) / 2) +
                getKthSmallestNum(nums1, 0, n - 1, nums2, 0, m - 1, (n + m + 2) / 2)) / 2;
    }

    // 递归函数作用：从两数组中获得第k小的数
    public static int getKthSmallestNum(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        if (left1 > right1) {
            return nums2[left2 + k - 1];
        }
        if (left2 > right2) {
            return nums1[left1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int m = k / 2;
        // 无论A数组长度是否>=m，只要对应的数小于B，就要截去相应部分。
        int index1 = Math.min(left1 + m - 1, right1);
        int index2 = Math.min(left2 + m - 1, right2);

        if (nums1[index1] < nums2[index2]) {
            return getKthSmallestNum(nums1, left1 + m, right1, nums2, left2, right2, k - Math.min(m, right1 - left1 + 1));
        } else {
            return getKthSmallestNum(nums1, left1, right1, nums2, left2 + m, right2, k - Math.min(m, right2 - left2 + 1));
        }
    }

    public static double comparator(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            arr[index++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            arr[index++] = nums2[i];
        }
        Arrays.sort(arr);
        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        } else {
            return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 3, 5};
//        int[] nums2 = {2, 4, 6};
        int[] nums1 = {4};
        int[] nums2 = {1, 2, 3, 5, 6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(comparator(nums1, nums2));
    }
}
