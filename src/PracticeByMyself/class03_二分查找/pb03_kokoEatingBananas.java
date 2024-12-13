package PracticeByMyself.class03_二分查找;

import java.util.Arrays;


/**
 * @author mdy
 * @date 2024-12-12 17:27
 * @description <a href="https://leetcode.cn/problems/koko-eating-bananas/">...</a>
 */
public class pb03_kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles, 5));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        // 找出k的极小和极大值
        int leftMinK = Arrays.stream(piles).min().getAsInt();
        int rightMaxK = Arrays.stream(piles).max().getAsInt();

        while (leftMinK <= rightMaxK) {
            int k = leftMinK - ((leftMinK - rightMaxK) >> 1);
            if (spendTime(piles, k) <= h) {
                res = k;
                rightMaxK = k - 1;
            } else {
                leftMinK = k + 1;
            }
        }

        return res;
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
