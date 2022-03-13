package 回溯法;
import org.junit.Test;

import java.util.*;
public class Offer46 {


    @Test
    public void test(){
        System.out.println(translateNum(120));
    }
    Map<Integer,Character> map ;
    public int translateNum(int num) {
        map = new HashMap<>();
        for(int i = 0;i<26;i++){
            map.put(i,(char)('a'+i));
        }
        return getRes(String.valueOf(num));
    }

    private int getRes(String s){
        if(s.length()<=1){return 1;}
        int stnum = Integer.valueOf(s.substring(0,1));
        if(stnum==0){
            return getRes(s.substring(1));
        }
        int qian = Integer.valueOf(s.substring(0,2));
        if(qian<=25){
            return getRes(s.substring(1))+getRes(s.substring(2));
        }
        else{
            return getRes(s.substring(1));
        }
    }
}
