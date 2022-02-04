package 动态规划;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T887 {
    @Test
    public void test(){
        System.out.println(superEggDrop(2,100));
    }

    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for(int i = 1 ;i<=n;i++){
            memo[1][i] = i;
        }
        for(int i = 1;i<=k;i++){
            memo[i][1] = 1;
        }
        for(int i = 2;i<=k;i++){
            for(int j = 2;j<=n;j++){
                memo[i][j] = dp_opt(i,j);
            }
        }
        return memo[k][n];
    }

    int[][] memo;
    public int dp(int i ,int j){
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        //这里相当于求每对【dp(i-1,kk-1)+1，,dp(i,j-kk)+1】中的最大值，在求这些最大值中的最小值，
        //那么取得最小值的时候，dp(i-1,kk-1)+1，,dp(i,j-kk)+1这两个数应该相等或近似（一个随着kk递增，一个随着kk递减）
        int minvalue = Integer.MAX_VALUE;
        for(int kk = 2;kk<=j;kk++){
            minvalue = Math.min(minvalue,Math.max(dp(i-1,kk-1)+1,dp(i,j-kk)+1));
        }
        return minvalue;
    }

    public int dp_opt(int i ,int j){
        if(j==0){
            return 0;
        }
        if(i==1){
            return j;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int minvalue = Integer.MAX_VALUE;
        int lo = 1;
        int hi = j;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            int broken = dp_opt(i-1,mid-1);
            int not_broken = dp_opt(i,j-mid);
            if(broken>not_broken){
                hi=mid-1;
                minvalue = Math.min(minvalue,broken+1);
            }
            else{
                lo=mid+1;
                minvalue = Math.min(minvalue,not_broken+1);
            }
        }
        return minvalue;
    }

}
