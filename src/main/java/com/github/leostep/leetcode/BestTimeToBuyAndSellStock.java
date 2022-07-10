package com.github.leostep.leetcode;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            final int currentPrice = prices[i];
            final int potentialProfit = currentPrice - buyPrice;
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
            if (currentPrice < buyPrice) {
                buyPrice = currentPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
