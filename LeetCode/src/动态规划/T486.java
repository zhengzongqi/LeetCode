package 动态规划;

import org.junit.Test;

public class T486 {
    @Test
    public void test(){

    }

    int[][][] dp ;
    int len;
    public boolean PredictTheWinner(int[] nums) {
        len = nums.length;
        dp = new int[len][len][2];
        int totalscore = 0;
        for(int i = 0;i<len;i++){
            totalscore+=nums[i];
            for(int j = 0;j<len;j++){
                //Arrays.fill(dp[i][j],-1);
                if(i==j){
                    dp[i][j][1]=nums[i];
                }
            }
        }

        for(int i = len-1;i>=0;i--){
            for(int j = i+1;j<len;j++){
                dp[i][j][1] = Math.max(nums[i]+dp[i+1][j][0], nums[j]+dp[i][j-1][0]);
                dp[i][j][0] = Math.min(dp[i+1][j][1], dp[i][j-1][1]);
            }
        }

        return totalscore <= dp[0][len-1][1]*2?true:false;

    }


}

