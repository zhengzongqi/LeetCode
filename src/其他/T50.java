package 其他;

import java.util.HashMap;
import java.util.Map;

public class T50 {
    Map<Long,Double> map;

    public double myPow(double x, int n) {
        map = new HashMap<>();
        long N = n;
        long temp = Math.abs(N);
        double res = myPow1(x,temp);
        if(n<0){
            return 1.0/res;
        }
        else{
            return res;
        }
    }

    public double myPow1(double x, long n) {
        if(n==0){return 1;}
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n%2==1){
            double res = myPow1(x,n/2)*myPow1(x,n/2)*x;
            map.put(n,res);
            return res;
        }
        else{
            double res = myPow1(x,n/2)*myPow1(x,n/2);
            map.put(n,res);
            return res;
        }
    }
}
