package 动态规划;

import org.junit.Test;

public class T1143 {


    @Test
    public void test(){
        //System.out.println(longestCommonSubsequence("bsbininm","jmjkbkjkv"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char text1_c = text1.charAt(0);
        char text2_c = text2.charAt(0);
        int[][] dp = new int[text2.length()][text1.length()];
        dp[0][0] = text1_c==text2_c?1:0;
        for(int i = 1 ; i < text1.length();i++){
            if(text1.charAt(i)==text2_c){
                dp[0][i] = 1;
            }
            else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i = 1 ; i < text2.length();i++){
            if(text2.charAt(i)==text1_c){
                dp[i][0] = 1;
            }
            else{
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i = 1 ; i < text2.length();i++){
            for(int j = 1 ; j <text1.length();j++){
                if(text1.charAt(j)==text2.charAt(i)){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text2.length()-1][text1.length()-1];
    }
}
