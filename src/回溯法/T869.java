package 回溯法;

import org.junit.Test;

public class T869 {
    @Test
    public void test(){
        System.out.println(reorderedPowerOf2(1));
    }
    public boolean reorderedPowerOf2(int n) {
        backTrace(String.valueOf(n),0);
        return res;
    }

    boolean res = false;

    //回溯法
    public void backTrace(String s,int idx){
        if(res == true){
            return;
        }
        if(isVaild(s)){
            res = true;
        }
        for(int i = idx;i<s.length();i++){
            if(idx==0&&s.charAt(i)=='0'){

            }
            else {
                backTrace(swap(s,i,idx),idx+1);
            }
        }
    }


    //这里应该能再优化
    public boolean isVaild(String s){
        int i = Integer.valueOf(s);
        while(true){
            if(i==1){
                return true;
            }
            if(i%2!=0){
                return false;
            }
            i = i /2;
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
