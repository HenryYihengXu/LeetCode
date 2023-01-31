class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int boughtPrice = Integer.MAX_VALUE;
        for (int i = 0; i <prices.length; i++) {
            int price = prices[i];
            if (price >= boughtPrice) {
                profit = Math.max(profit, price - boughtPrice);
            } else {
                boughtPrice = price;
            }
        }
        return profit;
    }
}
