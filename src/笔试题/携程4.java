package 笔试题;
import java.util.*;
public class 携程4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m_count = sc.nextInt();
        int d_count = sc.nextInt();
        int y = sc.nextInt();
        int m =sc.nextInt();
        int d = sc.nextInt();
        String s = dateToStr(y,m,d);
        while(true){
            if(check(dateToStr(y,m,d))){
                System.out.println(y+" "+m+" "+d);
                break;
            }
            d++;
            if(d>d_count){m++;d=1;}
            if(m>m_count){y++;m=1;}
        }
    }




    private static String dateToStr(int y,int m,int d){
        return new StringBuilder().append(y).append(m).append(d).toString();
    }

    private static boolean check(String s){
        int i = 0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){return false;}
            i++;
            j--;
        }
        return true;
    }



    private static String gethuiwen(String s){
        int len = s.length();
        if(len==2){
            StringBuilder ss = new StringBuilder(s.substring(0,len/2));
            return ss.append(ss.reverse()).toString();
        }
        else{
            StringBuilder ss = new StringBuilder(s.substring(0,len/2));
            return ss.append(s.charAt(len/2+1)).append(ss.reverse()).toString();
        }
    }

}
