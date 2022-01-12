package 动态规划;

import org.junit.Test;

public class T1884 {

    @Test
    public void test(){
        System.out.println(twoEggDrop(100));
    }
    public int twoEggDrop(int n) {
        int[][] dp = new int[2][n+1];
        for(int i = 0 ;i<=n;i++){
            dp[0][i]=  i;
            dp[1][i] = n;
        }
        dp[0][0] = dp[1][0] = 0;

        for(int i = 1;i<=n;i++){
            int minvalue = n;
            for(int j = 1;j<=i;j++){
                minvalue = Math.min(Math.max(dp[0][j-1]+1,dp[1][i-j]+1),minvalue);
            }
            dp[1][i] = minvalue;
        }
        return dp[1][n];
    }
}
