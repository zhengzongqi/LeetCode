package 其他;

import org.junit.Test;

public class Offer44 {

    @Test
    public void test(){
        System.out.println(findNthDigit(1000000000));
    }
    public int findNthDigit(int n) {
        if(n<10){return n;}
        int shuwei = 1;
        long shunum = 9;
        long total = 10;
        long st = 1;
        while(n>total){
            shuwei++;
            shunum*=10;
            st=st*10;
            total+=shuwei*shunum;
        }
        long remain = n-total+shuwei*shunum;
        long shucount = remain/shuwei;
        long idx = remain%shuwei;
        long res = st+shucount;
        char c = String.valueOf(res).charAt(Math.toIntExact(idx));
        return Integer.parseInt(String.valueOf(c));
    }
}
