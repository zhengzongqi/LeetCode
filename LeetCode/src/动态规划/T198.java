package 动态规划;

public class T198 {


    //dp[i]:前i个屋子盗窃的最大金额
    //对于第i座房子，选择偷：那么i-1房子不能偷,dp[i]=dp[i-2]+money(i)
    //不偷：dp[i]=dp[i-1]
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2 ;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }
}
