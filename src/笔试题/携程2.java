package 笔试题;

import java.util.*;

public class 携程2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        while(count>0){
            count--;
            int num1 = sc.nextInt();
            int num2= sc.nextInt();
            int res = 0;
            while(num2!=0){
                res+=num2%10*num1;
                num2/=10;
            }
            System.out.println(res);
        }
    }
}
