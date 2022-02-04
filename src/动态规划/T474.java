package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T474 {


    @Test
    public void test(){
        System.out.println(findMaxForm(new String[]{"10","0", "1"},1,1));
    }

    public int findMaxForm(String[] strs, int m, int n) {

        List<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{0,0});
        for(int i = 0 ;i<strs.length;i++){
            String s = strs[i];
            Integer[] in = new Integer[2];
            in[0]=0;
            in[1]=0;
            for(int j = 0;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    in[0]+=1;
                }
                else {
                    in[1]+=1;
                }
            }
            list.add(in);
        }

        int[][][] dp = new int[m+1][n+1][strs.length+1];

        for(int k =0;k<strs.length;k++){
            for(int i =0;i<m+1;i++){
                for(int j = 0;j<n+1;j++){
                    dp[i][j][k] = 0;
                }}}

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i>=list.get(1)[0]&&j>=list.get(1)[1]){
                    dp[i][j][1] = 1;
                }
            }
        }

        for(int k =1;k<=strs.length;k++){
            int count0 = list.get(k)[0];
            int count1 = list.get(k)[1];
            for(int i =0;i<m+1;i++){
                for(int j = 0;j<n+1;j++){
                    if(i-count0<0||j-count1<0){
                        dp[i][j][k] = dp[i][j][k-1];
                    }
                    else{
                        dp[i][j][k] = Math.max(dp[i][j][k-1],dp[i-count0][j-count1][k-1]+1);
                    }

                }
            }
        }

        return dp[m][n][strs.length];

    }
}
