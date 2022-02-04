package 其他;

import org.junit.Test;

public class T319 {
    @Test
    public void test(){
        bulbSwitch(5);
    }


    public int bulbSwitch(int n) {
        int res = 0;
        for(int i = 1 ;i <= n ; i++ ){
            if(Calc(i)){
                res++;
            }
        }
        return res;
    }

    public boolean Calc(int a){
        int c =(int)Math.sqrt(a);
        if(c*c==a){
            return true;
        }
        else{
            return false;
        }
    }
}
