package 动态规划;

public class T122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i<prices.length;i++){
            //不持有股票，要么就是今天刚卖，要么就是之前没买，今天也不买
            //dp[i-1][0]:第i天不买股票
            //dp[i-1][1] + prices[i]:第i天卖出股票(在昨天持有股票的收益下卖出，获得今日股价)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //持有股票，要么就是今天刚买，要么就是之前买了，今天继续观望
            //dp[i-1][1]:第i天不卖股票
            //dp[i-1][0] - prices[i]：第i天买入股票(在昨天不持有股票的情况下买入，扣今日股价)
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
