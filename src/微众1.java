import java.util.*;

public class 微众1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        while(num!=0){
            if(num%16>=10){
                res++;
            }
            num/=16;
        }
        System.out.println(res);
    }
}
