package PracticeByMyself.class01_数组.method04_二分查找;


/**
 * @author mdy
 * @date 2024-12-13 11:05
 * @description <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/">...</a>
 */

public class pb07_运货 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(weights, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (spendDays(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int spendDays(int[] weights, int capacity) {
        int days = 0;
        int curCapacity;
        int index = 0;
        while (index < weights.length) {
            curCapacity = capacity;
            while (index < weights.length && curCapacity >= weights[index]) {
                curCapacity -= weights[index++];
            }
            days++;
        }

        return days;
    }
}
