import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class 腾讯音乐1 {

    @Test
    public void main(){
        System.out.println(getGeshiNum(4,5));
    }
    int chushu = 1000000;
    public int numsOfStrings (int n, int k) {
        int remaincount = n-2*k;
        long geshishu = getGeshiNum(remaincount,k)%chushu;
        long fuhaotianchongshu = 26*(long)(Math.pow(25,k-1))%chushu;
        return (int) (fuhaotianchongshu*geshishu);
    }
    //n个相同球放到m个不同盒子里面
    public long getGeshiNum(int n,int m){
        if(n==0||m==1){
            return 1;
        }
        int a1 = n+m-1;
        int a2 = m-1;

        BigInteger up = new BigInteger("1");
        BigInteger down = new BigInteger("1");
        for(int i = 0;i<m-1;i++){
            up=up.multiply(new BigInteger(String.valueOf(a1)));
            a1--;
            down=down.multiply(new BigInteger(String.valueOf(a2)));
            a2--;
        }
        int res = up.divide(down).intValue();
        return res;

    }

}
