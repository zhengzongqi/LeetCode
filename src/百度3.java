import java.util.Scanner;

public class 百度3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while(count>0){
            count--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] num = new int[n];
            int ji = 0;
            int ou = 0;
            for(int i = 0;i<n;i++){
                num[i] = sc.nextInt();
                if(num[i]%2==0){
                    ou++;
                }
                else {
                    ji++;
                }
            }
            int res = 0;
            //选择k个数，其中有i个奇数
            for(int i =0;i<=k;i+=2){
                if(ou<k-i){continue;}
                if(ji<i){break;}
                //从ji个奇数里选i个奇数
                int num1 = choose(ji,i);
                //从ou个偶数里选k-i个偶数
                int num2 = choose(ou,k-i);
                res+=num2*num1%(10e9+7);
            }
            System.out.println((int)(res%(10e9+7)));
        }
    }
    //从a个数里选出b个数
    public static int choose(int a,int b){
        if(b==0||a==b){
            return 1;
        }
        long up = 1;
        long down =1;
        b = Math.min(b,a-b);
        long res = 1;
        long acopy = a;
        for(int i = 1;i<=b;i++){

            res*=acopy%(10e9+7);
            acopy--;
            down*=i;
            if(res%down==0){
                res = res/down;
                down=1;
            }

        }
        return (int) (res%(10e9+7));
    }
}
