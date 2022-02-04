package 动态规划;

import org.junit.Test;

public class T518 {
    @Test
    public void test(){
        System.out.print(change(7,new int[]{2}));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0 ; i<=coins.length;i++){
            for(int j = 0;j<=amount;j++){
                dp[i][j]=0;
            }
        }
        for(int i = 0;i<=coins.length;i++){
            dp[i][0] = 1;
        }

        //dp[i][j]=使用前i种硬币，恰好装满容量为j的背包的方案数
        for(int i = 1 ; i<=coins.length;i++){
            for(int j = 1;j<=amount;j++){
                int weighti = coins[i-1];
                int icount=0;
                while(icount*weighti<=j){
                    dp[i][j] = dp[i][j]+dp[i-1][j-icount*weighti];
                    icount++;
                }
            }
        }
        return dp[coins.length][amount];

    }
}
