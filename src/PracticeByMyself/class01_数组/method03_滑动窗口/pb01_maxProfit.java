package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-14 10:42
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 * 思路1：使用滑动窗口
 * 思路2：观察出规律后直接做，最大值一定是数组最小值右边的最大值减去它。
 */
public class pb01_maxProfit {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

//        int profit;
//        int left = 0, right = 0;
//        while (right < prices.length) {
//            int curPrice = prices[right++];
//            profit = curPrice - prices[left];
//
//            while (left < right - 1 && profit < 0) {
//                profit = curPrice - prices[++left];
//            }
//            maxProfit = Math.max(maxProfit, profit);
//        }

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
