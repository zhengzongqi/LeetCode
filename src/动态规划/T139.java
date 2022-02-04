package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T139 {

    @Test
    public void test(){
        System.out.println(wordBreak("leetcode", new ArrayList<String>(){
            {
                add("leet");
                add("code");
            }
        }));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 0 ; i <= len;i++){
            //对应dp[i+1]；
            boolean bool = false;
            for(int j = 0;j<wordDict.size();j++){
                String word = wordDict.get(j);
                int wordlen = word.length();
                if(wordlen>i){

                }
                else{
                    String endword = s.substring(i-wordlen,i);
                    if(endword.equals(word)&&dp[i-wordlen]==true){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len];
    }
}
