package 动态规划;

import org.junit.Test;

public class T516 {
    @Test
    public void test(){
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {

        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ; i++){
            dp[i][i] = 1;
        }
        for(int i = 1 ;i<len;i++){
            if(s.charAt(i-1)==s.charAt(i)){
                dp[i-1][i] = 2;
            }
            else{
                dp[i-1][i] = 1;
            }
        }

        for(int i = 2 ; i<len;i++){
            for(int j = 0 ; j < len-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                    dp[j][j+i] = dp[j+1][j+i-1]+2;
                }
                else{
                    dp[j][j+i] = Math.max(dp[j+1][j+i],dp[j][j+i-1]);
                }
            }
        }

        return dp[0][len-1];
    }
}
