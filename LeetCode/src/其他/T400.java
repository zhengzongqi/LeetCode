package 其他;

import org.junit.Test;

public class T400 {
    @Test
    public void test(){
        System.out.println(findNthDigit(
                1909481100));
    }
    public int findNthDigit(int n) {
        if (n<=9){
            return n;
        }
        int start = 1;
        int multinum =9;
        int len = 1;
        while(n-multinum*len>0){
            n = n-multinum*len;
            multinum*=10;
            start*=10;
            len++;
            if(Integer.MAX_VALUE / multinum < len){
                break;
            }
        }
        int numcount = n/len;
        if(n%len==0){
            start +=numcount-1;
            String s = String.valueOf(start);
            return s.charAt(s.length()-1)-'0';
        }
        else{
            start +=numcount;
            String s = String.valueOf(start);
            return s.charAt(n%len-1)-'0';
        }

    }

    public int findNthDigit1(int n) {
        int cur = 1, base = 9;
        while(n > cur * base){
            n -= cur * base;
            cur++;
            base*=10;
            if(Integer.MAX_VALUE / base < cur){
                break;
            }
        }
        n--;
        int num = (int)Math.pow(10,cur - 1) + n / cur, idx = n % cur;
        return num / (int)Math.pow(10,cur - 1 - idx) % 10;
    }
}
