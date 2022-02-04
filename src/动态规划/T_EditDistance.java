package 动态规划;

import org.junit.Test;

public class T_EditDistance {
    @Test
    public void test(){

        System.out.println(EditDistance("","b"));
    }

    public int EditDistance(String s1,String s2){
        if(s1==""){
            return s2.length();
        }
        if(s2==""){
            return s1.length();
        }
        if(s1.equals(s2)){
            return 0;
        }
        int result = 0;

        int[][] dp = new int[s2.length()][s1.length()];
        char s1_c = s1.charAt(0);
        char s2_c = s2.charAt(0);
        dp[0][0] = s1_c==s2_c?0:1;
        boolean s1_b = false;
        boolean s2_b = false;
        for(int i = 1 ; i<s1.length();i++){
            if(s1.charAt(i)==s2_c){
                if(s1_b==false){
                    dp[0][i] = dp[0][i-1];
                    s1_b = true;
                }
                else{
                    dp[0][i] = dp[0][i-1]+1;
                }
            }
            else{
                dp[0][i] = dp[0][i-1]+1;
            }
        }

        for(int i = 1 ; i<s2.length();i++){
            if(s2.charAt(i)==s1_c){
                if(s2_b==false){
                    dp[i][0] = dp[i-1][0];
                    s2_b = true;
                }
                else{
                    dp[i][0] = dp[i-1][0]+1;
                }
            }
            else{
                dp[i][0] = dp[i-1][0]+1;
            }
        }


        for(int i = 1 ; i<s2.length();i++){
            for(int j = 1 ; j <s1.length();j++){
                if(s1.charAt(j)==s2.charAt(i)){
                    dp[i][j] = dp[i-1][j-1];
                }
//                else if (dp[i-1][j]==dp[i][j-1]&&dp[i][j-1]==dp[i-1][j-1]){
//                    dp[i][j] = dp[i-1][j-1];
//                }
                else{
                    int minvalue = Math.min(dp[i-1][j],dp[i][j-1]);
                    minvalue = Math.min(minvalue,dp[i-1][j-1]);
                    dp[i][j] = minvalue+1;
                }
            }
        }


        return dp[s2.length()-1][s1.length()-1];
    }
}
