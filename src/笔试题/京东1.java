package 笔试题;
import java.math.*;
import java.util.*;

public class 京东1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger N = BigInteger.valueOf(sc.nextLong());
        BigInteger X = BigInteger.valueOf(sc.nextLong());
        sc.nextLine();
        String s = sc.nextLine();

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='U'){
                X=U(X);
            }
            else if(c=='L'){
                X=L(X);
            }
            else if(c=='R'){
                X=R(X);
            }
        }
        System.out.println(X.toString());

    }
    static BigInteger num1 = new BigInteger("1");
    static BigInteger num2 = new BigInteger("2");
    public static BigInteger U (BigInteger i){
        return i.divide(num2);
    }
    public static BigInteger L (BigInteger i){
        return i.multiply(num2);
    }
    public static BigInteger R (BigInteger i){
        return i.multiply(num2).add(num1);
    }
}
