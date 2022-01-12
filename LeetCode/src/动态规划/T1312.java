package 动态规划;

//给你一个字符串s，每一次操作你都可以在字符串的任意位置插入任意字符。
//        请你返回让s成为回文串的最少操作次数。
//        「回文串」是正读和反读都相同的字符串。

import java.util.ArrayList;
import java.util.List;

public class T1312 {

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 0 ;
        for(int i = 1 ; i<s.length();i++){
            dp[i][i] = 0;
            dp[i-1][i] = s.charAt(i-1)==s.charAt(i)?0:1;
        }
        for(int i = 2;i<s.length();i++){
            for(int j = 0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                    dp[j][j+i] = Math.min(dp[j][j+i-1],dp[j+1][j+i])+1;
                    dp[j][j+i] = Math.min(dp[j][j+i],dp[j+1][j+i-1]);
                }
                else{
                    dp[j][j+i] = Math.min(dp[j][j+i-1],dp[j+1][j+i])+1;
                }

            }
        }
        return dp[0][s.length()-1];
    }
}
