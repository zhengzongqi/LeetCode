package 笔试题;

import java.util.*;

public class 携程1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='>'||c=='<'||c=='='){
                res += " "+c + " ";
            }
            else if(c==' '){

            }
            else{
                res += c;
            }
        }
        System.out.println(res);
    }


    public void test(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='>'||c=='<'||c=='='){
                res += " "+c + " ";
            }
            else if(c==' '){

            }
            else{
                res += c;
            }
        }
        System.out.println(res);
    }

}
