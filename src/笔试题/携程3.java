package 笔试题;

import java.util.*;

public class 携程3 {
    private static Map<Integer,Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        int[] numzhi = new int[len];
        for(int i = 0 ;i<len;i++){
            nums[i] = sc.nextInt();
            set.clear();
            numzhi[i] = getNumZhi(nums[i]);
        }
        int res = 0;
//        double cishu = Math.pow(2,len-1);
//        for(int i=0;i<len;i++){
//            res += (numzhi[i]*cishu)%(10e9+7);
//        }
//        System.out.println(res);


    }
    static Set<Integer> set = new HashSet<>();
    private static int getNumZhi(int num){
        if(num==1||num==2){return num-1;}
        if(isPrime(num)){return 1;}
        else{
            int res = 0;
            int zhi = 2;
            for(int i = 2;i<num;i++){
                if(num%i==0){
                    res++;
                    while(num%i!=0){
                        num=num/i;
                    }
                }
            }
            return res;
        }
    }

    private static boolean isPrime(int number){
        for(int i = 2 ;i<Math.sqrt(number);i++){
            if(number%i==0){return false;}
        }
        return true;
    }
}
