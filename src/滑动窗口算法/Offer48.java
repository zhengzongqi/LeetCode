package 滑动窗口算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer48 {

    @Test
    public void test(){

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    //滑动窗口
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> window = new HashMap<Character,Integer>();
        int left = 0 ;
        int right = 0;
        int result = 0;
        while(right!=s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                char c_l = s.charAt(left);
                left++;
                window.put(c_l,window.getOrDefault(c_l,0)-1);
            }
            result = Math.max(right-left,result);
        }
        return  result;
    }

    //暴力解法
    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0){
            return 0 ;
        }

        String maxstr = s.substring(0,1);
        for(int a = 0 ; a<s.length()-1;a++){
            for(int b = 1;b<s.length()-a;b++){
                String ss = s.substring(a,b+a);
                char c = s.charAt(a+b);
                if(!ss.contains(c+"")){

                    if(maxstr.length()<=ss.length()+1){
                        maxstr = ss+s.charAt(a+b);
                    }
                }
                else{
                    break;
                }
            }
        }


        return maxstr.length();
    }
}
