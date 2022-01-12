package 动态规划;

import org.junit.Test;

public class T312 {

    @Test
    public void test(){
        System.out.print(maxCoins(new int[]{3,1,5}));
    }

    public int maxCoins(int[] nums) {
        int len = nums.length+2;
        int[] point = new int[len];
        for(int i = 0 ;i<nums.length;i++) {
            point[i+1] = nums[i];
        }
        point[0]=1;
        point[len-1]=1;
        int[][] dp = new int[len][len];

        for(int i = nums.length ; i>=0;i--){
            for(int j = i+1 ; j < len;j++){
                int maxscope = 0;
                for(int k = i+1;k<j;k++){
                    maxscope = Math.max(maxscope,dp[i][k]+dp[k][j]+point[i]*point[j]*point[k]);
                }
                dp[i][j] = maxscope;
            }
        }
        return dp[0][len-1];
    }
}
