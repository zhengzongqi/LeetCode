package 其他;

import org.junit.Test;

import java.math.BigInteger;

public class Offer10 {
    @Test
    public void test(){
        System.out.println(numWays(27));
    }
    public int numWays(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;

        for(int i = 2; i < n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }


}
