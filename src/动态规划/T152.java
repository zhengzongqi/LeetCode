package 动态规划;

import org.junit.Test;

import java.util.ArrayList;

public class T152 {
    @Test
    public void test(){
        System.out.println( maxProduct(new int[]{-1,0,-1}) );
    }

    public int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp = new int[2][nums.length];

        if(nums[0]<0){
            dp[1][0] = nums[0];
        }
        else{
            dp[0][0] = nums[0];
        }
        for(int i = 1 ; i< nums.length;i++){
            if(nums[i]<0){
                dp[0][i] = dp[1][i-1]*nums[i];
                dp[1][i] = Math.min(dp[0][i-1]*nums[i],nums[i]);
            }
            else{
                dp[0][i] = Math.max(dp[0][i-1]*nums[i],nums[i]);
                dp[1][i] = dp[1][i-1]*nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max,dp[0][i]);
            max = Math.max(max,dp[1][i]);
        }
        return max;


    }
}
