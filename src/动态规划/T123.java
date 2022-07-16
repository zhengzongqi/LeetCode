package 动态规划;

import org.junit.Test;

import java.util.Arrays;

public class T123 {
    @Test
    public void test(){
        //System.out.println(maxProfit(new int[]{1,2,3,4}));
    }

    /*
    dp[i][0]前i天未作任何操作的最大利润
    dp[i][1]前i天进行了1次买，0次卖的最大利润
    dp[i][2]前i天进行了1次买，1次卖的最大利润
    dp[i][3]前i天进行了2次买，1次卖的最大利润
    dp[i][4]前i天进行了2次买，2次卖的最大利润
    */
    public int maxProfit(int[] prices) {
        if(prices.length<2){return 0;}
        int[][] dp = new int[prices.length+1][5];

        //全部置为最小值，防止这一系列情况：比如第三天不可能进行了2次买2次卖，但是dp[3][4]依旧会算出一个结果；并且
        //这个结果还会影响到后续计算
        for(int i=0;i<=prices.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for(int i = 2;i<=prices.length;i++){
            dp[i][0] = 0;
            if(i>=1){dp[i][1] = Math.max(dp[i-1][0]-prices[i-1],dp[i-1][1]);};
            if(i>=2){dp[i][2] = Math.max(dp[i-1][1]+prices[i-1],dp[i-1][2]);};
            if(i>=3){dp[i][3] = Math.max(dp[i-1][2]-prices[i-1],dp[i-1][3]);};
            if(i>=4){dp[i][4] = Math.max(dp[i-1][3]+prices[i-1],dp[i-1][4]);};
        }
        int res = 0;
        for(int i = 0;i<5;i++){
            res = Math.max(dp[prices.length][i],res);
        }
        return res;
    }
}
