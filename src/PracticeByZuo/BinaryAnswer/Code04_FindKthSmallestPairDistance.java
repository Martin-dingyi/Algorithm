package PracticeByZuo.BinaryAnswer;


import java.util.Arrays;
import java.util.PriorityQueue;

// 找出第K小的数对距离
// 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
// 给你一个整数数组 nums 和一个整数 k
// 数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length
// 返回 所有数对距离中 第 k 小的数对距离。
// 测试链接 : https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
public class Code04_FindKthSmallestPairDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int right = nums[nums.length - 1] - nums[0];
        int left = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getMinCount(nums, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 获得距离小于等于val的数对有几个
    public static int getMinCount(int[] nums, int val) {
        int ans = 0;
        for (int i = 0, j = i + 1; j < nums.length; i++) {
            while (j < nums.length && Math.abs(nums[i] - nums[j]) <= val) {
                ans += j++ - i;
            }
        }
        return ans;
    }

    public static int compare(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                heap.add(Math.abs(nums[i] - nums[j]));
            }
        }
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1};
        int[] nums2 = {1, 1, 1};
        int[] nums3 = {1, 6, 1};
        int[] nums4 = {1, 1, 6};
        System.out.println(smallestDistancePair(nums1, 1)); // 0
        System.out.println(smallestDistancePair(nums2, 2)); // 0
        System.out.println(smallestDistancePair(nums3, 3)); // 5
        System.out.println(getMinCount(nums4, 2)); // 1
    }
}
