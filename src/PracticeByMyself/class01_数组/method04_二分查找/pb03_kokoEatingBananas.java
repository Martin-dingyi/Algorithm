package PracticeByMyself.class01_数组.method04_二分查找;

import java.util.Arrays;


/**
 * @author mdy
 * @date 2024-12-12 17:27
 * @description <a href="https://leetcode.cn/problems/koko-eating-bananas/">...</a>
 */
public class pb03_kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles1 = {30,11,23,4,20};
        int[] piles2 = {312884470};
        System.out.println(minEatingSpeed(piles1, 5));
        System.out.println(minEatingSpeed(piles2, 312884469)); // 2
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // 找出k的极小和极大值
        int sum = 0;
        int max = piles[0];
        for (int pile : piles) {
            sum += pile;
            max = Math.max(max, pile);
        }
        int left = sum / h;
        int right = max;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (spendTime(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int spendTime(int[] piles, int v) {
        int time = 0;
        for (int pile : piles) {
            if (v >= pile) {
                time++;
            } else {
                while (pile > 0) {
                    pile -= v;
                    time++;
                }
            }
        }

        return time;
    }
}
