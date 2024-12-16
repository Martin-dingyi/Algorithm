package PracticeByMyself.class04_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-14 10:42
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 */
public class pb01_maxProfit {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
