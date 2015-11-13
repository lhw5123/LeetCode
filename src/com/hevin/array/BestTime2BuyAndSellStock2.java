package com.hevin.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class BestTime2BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        // 必须要先买再卖
        int profit = 0;
        int i = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i++];
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
}
