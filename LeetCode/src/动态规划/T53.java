package 动态规划;

import org.junit.Test;

public class T53 {
    @Test
    public void test(){
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1 ; i<nums.length;i++){
            dp[i] = Math.max( dp[i-1]+nums[i] , nums[i] );
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
