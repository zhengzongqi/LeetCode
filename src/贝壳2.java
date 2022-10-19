import java.util.*;
public class 贝壳2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while(count>0){
            count--;
            int l = sc.nextInt();
            int r = sc.nextInt();
            int res = 0;
            long prevS = S(l);
            if(l%prevS==1){res++;}
            for(int i = l+1 ; i <= r ; i++ ){
                long m = 0;
                if(i%10!=0){
                    prevS++;
                    m = prevS;
                }
                else{
                    int temp = i-1;
                    m = prevS;
                    while((temp%10)==9){
                        m-=9;
                        temp=temp/10;
                    }
                    m++;
                    prevS = m;
                }
                if(i%m==1){
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static long S(int n){
        long res = 0;
        while(n!=0){
            res+=n%10;
            n=n/10;
        }
        return res;
    }
}
