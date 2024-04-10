package MartinByZuo.自己的练习;

public class BestTimeToBuyAndSellStockIl {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIndex = 0, sellIndex;
        while (buyIndex < prices.length) {
            sellIndex = buyIndex + 1;
            while (sellIndex < prices.length && prices[sellIndex] > prices[sellIndex - 1]) {
                sellIndex++;
            }
            maxProfit += Math.max(0, prices[sellIndex - 1] - prices[buyIndex]);
            buyIndex = sellIndex;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4}; // 7
        int[] prices2 = {1, 2, 3, 4, 5}; // 4
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
}
