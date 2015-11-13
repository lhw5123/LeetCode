package com.hevin.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTime2BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 0, len = prices.length; i < len; i++) {
            // 当添加一个新元素时，要判断是将其加入数组还是作为新数组的起始元素。
            maxCur = Math.max(prices[i], maxCur + prices[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
