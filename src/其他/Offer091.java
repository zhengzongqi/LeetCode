package 其他;

import org.junit.Test;

import java.util.Arrays;

public class Offer091 {

    @Test
    public void test(){
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        for(int i = 0 ;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i = 0;i<3;i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1;i<costs.length;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+costs[i][2];
        }
        int res = Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
        return res;
    }

}
