package 回溯法;

import org.junit.Test;

import java.util.Arrays;

public class T503 {
    @Test
    public void test(){
        System.out.println(nextGreaterElement(2147483467));
    }
    public int nextGreaterElement(int n) {
        res=Integer.MAX_VALUE;
        s_n = String.valueOf(n);
        s_res="";
        char[] chars = s_n.toCharArray();
        Arrays.sort(chars);
        for(int i = chars.length-1;i>=0;i--){
            s_res+=chars[i];
        }
        if (s_res.equals(s_n)) {
            return -1;
        }
        N = n;
        backTrace(String.valueOf(n),0);
        if(s_res.length()<s_max.length()) {
            return Integer.valueOf(s_res);
        }
        return s_res.compareTo(s_max)>0?-1:Integer.valueOf(s_res);
    }

    int res ;
    int N;
    boolean contains_maxval=false;
    String s_max = "2147483647";
    String s_res ;
    String s_n ;
    //回溯法
    public void backTrace(String s,int idx){
        if(s.compareTo(s_n)>0&&s.compareTo(s_res)<0){
            s_res = s;
        }
        for(int i = idx;i<s.length();i++){
            if(idx==0&&s.charAt(i)=='0'){

            }
            else {
                backTrace(swap(s,i,idx),idx+1);
            }
        }
    }


    static String swap(String str , int i , int j ) {
        StringBuilder strB = new StringBuilder(str);

        char l = strB.charAt(i) , r = strB.charAt(j);

        strB.setCharAt(i,r);

        strB.setCharAt(j,l);

        return strB.toString();

    }


}
