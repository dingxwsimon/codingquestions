package LeetCode;

import java.util.Arrays;

public class BestTimetoBuyandSellStock
{

  public int maxProfit1(int[] prices)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (prices.length < 2) return 0;

    int buy_date = 0;
    int max_profit = 0;

    for (int i = 0 ; i < prices.length ; i++) {
      if (prices[i] < prices[buy_date]) {
        buy_date = i;
      }
      int tmp_profit = prices[i] - prices[buy_date];
      if (tmp_profit > max_profit) max_profit = tmp_profit;
    }
    return max_profit;
  }

  public int maxProfit2(int[] prices)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (prices == null || prices.length < 2) return 0;

    int maxProfit = 0;

    for (int i = 1 ; i < prices.length ; i++) {
      if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
    }
    return maxProfit;
  }

  //better, more clear, easy to remeber
  public int maxProfit3_1(int[] prices){
     int n = prices.length;
     if (n <= 1) return 0;
     int[] historyprofit = new int[n];
     int[] futureprofit = new int[n];
     int valley = prices[0];
     int peak = prices[n-1];
     int maxprofit = 0;
     for(int i = 0; i < n; i++){
       valley = Math.min(valley, prices[i]);
       if(i > 0){
         historyprofit[i] = Math.max(historyprofit[i-1], prices[i] - valley);
       }
     }
     for(int i = n-1; i >= 0; i--){
       peak = Math.max(peak, prices[i]);
       if(i < n-1){
         futureprofit[i] = Math.max(futureprofit[i+1], peak - prices[i]);
       }
       maxprofit = Math.max(historyprofit[i]+futureprofit[i], maxprofit);
     }
     return maxprofit;
  }
  
  
  
  // pass both
  public int maxProfit3(int[] prices)
  {
    int n = prices.length;
    if (n <= 1) return 0;
    int[] forwardMax = new int[n];
    int buy_date = 0;
    int max_profit = 0;
    for (int i = 0 ; i < n ; i++) {
      if (prices[i] < prices[buy_date]) {
        buy_date = i;
      }
      int tmp = prices[i] - prices[buy_date];
      if (tmp > max_profit) max_profit = tmp;
      forwardMax[i] = max_profit;
      System.out.println("i = " + i + " and buy_date is " + buy_date
          + " and forwardMax is " + Arrays.toString(forwardMax));
    }
    int ret = forwardMax[n - 1];
    int sell_date = n - 1;
    max_profit = 0;
    for (int i = n - 2 ; i >= 0 ; --i) {
      if (prices[i] > prices[sell_date]) sell_date = i;
      int temp = prices[sell_date] - prices[i];
      if (temp > max_profit) {
        max_profit = temp;
      }
      int finalprofit = max_profit + forwardMax[i];
      if (ret < finalprofit) ret = finalprofit;
      System.out.println("i = " + i + " and sell_date is " + sell_date
          + " and max_profit is " + max_profit);
    }
    return ret;
  }
  
  public int maxProfit4(int[] prices) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if(prices == null || prices.length < 2) return 0;
      int n = prices.length;
      int buy_date = 0;
      int sell_date = n-1;
      int max = 0;
      int[] history = new int[n];
      int[] future = new int[n];
      for(int i = 0; i < n; i++){
          if(prices[i] < prices[buy_date]){
              buy_date = i;
          }
          if(i > 0)
              history[i] = Math.max(history[i-1], prices[i]-prices[buy_date]);
      }
      for(int i = n - 1; i >= 0; i++){
          if(prices[i] > prices[sell_date]){
              sell_date = i;
          }
          if(i < n - 1)
              future[i] = Math.max(future[i+1], prices[sell_date] - prices[i]);
          max = Math.max(max, future[i]+history[i]);
      }
      return max;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
    System.out.println(b.maxProfit4(new int[] { 1,2 }));
  }

}
