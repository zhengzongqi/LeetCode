package 其他;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T1763 {
    @Test
    public void test(){
        System.out.println(longestNiceSubstring("Cc"));

    }

    public String longestNiceSubstring(String s) {

        int stidx = 0;
        int len = 0;
        for(int i = 0;i<s.length();i++){
            int upper = 0;
            int lower = 0;
            for(int j = 0;j+i<s.length();j++){
                char c = s.charAt(i+j);
                if(Character.isLowerCase(c)){
                    lower |= 1<<(c-'a') ;
                }
                else{
                    upper |=1<<(c-'A');
                }

                if(upper==lower&&j+1>len){
                    stidx = i;
                    len = j+1;
                }
            }
        }
        return s.substring(stidx,stidx+len);
    }
}
