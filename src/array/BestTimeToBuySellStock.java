package array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println("max profit ->" + BestTimeToBuySellStock.maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        if (len == 2)
            return (prices[1] - prices[0]) > 0 ? (prices[1] - prices[0]) : 0;
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < len; i++) {
            buy = Math.min(buy, prices[i]);
            maxProfit = Math.max(maxProfit, (prices[i] - buy));

        }
        return maxProfit;

    }

}
