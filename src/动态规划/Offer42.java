package 动态规划;

import org.junit.Test;

public class Offer42 {

    @Test
    public void test(){

        System.out.println(maxSubArray(new int[]{1,2}));
    }
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //dp[i]:以i结尾的连续数组最大值
        //dp[i+1] = max(dp[i]+nums[i+1],nums[i+1])
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1;i<nums.length;i++){
            if(dp[i-1]+nums[i]>nums[i]){
                dp[i]=nums[i]+dp[i-1];
            }
            else{
                dp[i]=nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
