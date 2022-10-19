package 笔试题;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 京东2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        while (count>0){
            count--;
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            //统计每种颜色个数
            int A = 0;
            int B = 0;
            int C = 0;
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='A'){A++;}
                if(c=='B'){B++;}
                if(c=='C'){C++;}
            }
            if(check(A,B,C)==true){
                System.out.println(0);
                continue;
            }
            if(printOnce(A,B,C,s) == true){
                System.out.println(1);
                continue;
            }
            else{
                System.out.println(2);
                continue;
            }
        }

    }

    public static boolean printOnce(int A, int B, int C, String s){
        int n =s.length()/3;
        int lowcount = 0;
        char[] lowcolor = new char[2];
        if(A<n){lowcolor[lowcount] ='A';lowcount++;}
        if(B<n){lowcolor[lowcount] ='B';lowcount++;}
        if(C<n){lowcolor[lowcount] ='C';lowcount++;}
        if(lowcount == 1){
            if(lowcolor[0] == 'A'){
                return checkinst1('A',n-A,s);
            }
            else if(lowcolor[0] == 'B'){
                return checkinst1('B',n-B,s);
            }
            else if(lowcolor[0] == 'C'){
                return checkinst1('C',n-C,s);
            }
        }
        return false;
    }

    public static boolean checkinst1(char lowcolor,int lowcount,String s){
        int record = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=lowcolor){
                record++;
                if(record==lowcount){
                    return true;
                }
            }
            else {
                record=0;
            }
        }
        return false;
    }

    public static boolean check(int a,int b,int c){
        return (a==b&&b==c)?true:false;
    }
}
