package 动态规划;

import org.junit.Test;

public class T343 {

    @Test
    public void test(){
        System.out.println(integerBreak(2));
    }

    public int integerBreak(int n) {
        if(n==2){return 1;}
        if(n==3){return 2;}
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n;i++){
            int max = i+1;
            for(int j = 0;j<=i/2;j++){
                max = Math.max(max,dp[i-j-1]*dp[j]);
            }
            dp[i] = max;
        }
        return dp[n-1];
    }
}
