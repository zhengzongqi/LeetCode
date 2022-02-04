package 动态规划;

import org.junit.Test;

public class T416 {
    @Test
    public void test(){
        System.out.print(canPartition( new int[]{1,5,11,5}));
    }
    //dp[i][j]表示前j件物品，能否恰好装满负载为i的书包
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        total=total/2;

        boolean[][] dp = new boolean[total+1][nums.length+1];
        dp[0][0]=true;
        for(int i = 1;i<=total;i++){
            for(int j =1;j<=nums.length;j++){
                if(dp[i][j-1]==false){
                    if(i-nums[j-1]<0){
                        dp[i][j]=false;
                    }
                    else if(dp[i-nums[j-1]][j-1]==false){
                        dp[i][j]=false;
                    }
                    else{
                        dp[i][j]=true;
                    }
                }
                else{
                    dp[i][j]=true;
                }
            }
        }
        return dp[total][nums.length];

    }
}
