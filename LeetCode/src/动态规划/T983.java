package 动态规划;

import org.junit.Test;

public class T983 {
    @Test
    public void test(){
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20},new int[]{7,2,15}));
    }


    public int mincostTickets(int[] days, int[] costs) {

        //dp[4][0]代表第4天不买票，前4个旅行天所花费的最低票价；
        int[][] dp = new int[days.length][4];
        for(int i = 0 ; i<days.length;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = costs[0];
        dp[0][2] = costs[1];
        dp[0][3] = costs[2];

        for(int i = 1 ;i<days.length;i++){
            //填dp[i][0]
            for(int j=i-1;j>=0;j--){
                if(days[j]+7>days[i]){
                    dp[i][0] =Math.min(dp[i][0],dp[j][2]);
                }
                if(days[j]+30>days[i]){
                    dp[i][0] =Math.min(dp[i][0],dp[j][3]);
                }
            }
            //填dp[i][1]
            int min = Math.min(dp[i-1][0],dp[i-1][1]);
            min = Math.min(min,dp[i-1][2]);
            min = Math.min(min,dp[i-1][3]);
            dp[i][1] = min+costs[0];
            dp[i][2] = min+costs[1];
            dp[i][3] = min+costs[2];
        }
        int res = Math.min(dp[days.length-1][0],dp[days.length-1][1]);
        res = Math.min(res,dp[days.length-1][2]);
        res = Math.min(res,dp[days.length-1][3]);
        return res;
    }
}
