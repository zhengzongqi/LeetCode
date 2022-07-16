package 动态规划;
import org.junit.Test;

import java.util.*;
public class Offer60 {

    @Test
    public void test(){
        System.out.println(dicesProbability(3));
    }

    public double[] dicesProbability(int n) {
        int[][] dp = new int[n][66];
        for(int i = 0;i<6;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<n;i++){
            for(int j = 0 ; j < 66;j++){
                for(int k = j - 6 ;k < j ; k++ ){
                    if(k>=0){
                        dp[i][j]+=dp[i-1][k];
                    }
                }
            }
        }
        double totalcount = Math.pow(6,n);
        List<Double> res = new ArrayList<>();
        for(int i = 0 ;i<66;i++){
            if(dp[n-1][i]!=0){
                res.add(dp[n-1][i]/totalcount);
            }
        }
        double[] res_ = new double[res.size()];
        for(int i = 0;i<res.size();i++){
            res_[i] = res.get(i);
        }

        return res_;
    }
}
