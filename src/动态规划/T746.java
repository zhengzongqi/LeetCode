package 动态规划;

import org.junit.Test;

public class T746 {
    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=2){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i = 2;i<dp.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
