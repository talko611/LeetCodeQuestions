package Easy;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//        Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;
        while(sellDay < prices.length){
            maxProfit = Math.max(maxProfit, prices[sellDay] - prices[buyDay]);
            if(sellDay == buyDay)
                ++sellDay;
            else if(prices[sellDay] < prices[buyDay])
                ++buyDay;
            else
                ++sellDay;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock solution = new Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(solution.maxProfit(new int[]{1,0,4,3,10}));
    }
}
