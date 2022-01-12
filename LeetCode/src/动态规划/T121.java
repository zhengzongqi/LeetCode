package 动态规划;

import org.junit.Test;

public class T121 {

    @Test
    public void test(){
        System.out.print(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++){
            int max = Math.max(prices[i] - min ,0);
            dp[i] = Math.max(dp[i-1],max);
            min = Math.min(prices[i],min);
        }
        return dp[prices.length-1];
    }
}
