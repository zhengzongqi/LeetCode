package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 携程4测试 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1;i<=len;i++){
            int[] result = new int[i];
            List<List<Integer>> res1 = getres(arr,0,result,i,i,arr.length);
            res.addAll(res1);
        }
        for(List<Integer> i :res){
            int mul = 1;
            for(Integer x:i){
                mul = (mul*x)%(1000000007);
            }
            sum = (sum+getNumOfZhi(mul))%(1000000007);
        }
        System.out.println(sum);

    }


    static List<List<Integer>> getres(int arr[], int start, int result[], int count, int NUM, int arr_len){
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start;i<arr_len+1-count;i++){
            result[count-1] = i;
            if(count - 1 == 0){
                int j;
                List<Integer> temp = new ArrayList<>();
                for(j = NUM-1;j>=0;j--){
                    temp.add(arr[result[j]]);
                }
                res.add(temp);
            }
            else
                res.addAll(getres(arr,i+1,result,count-1,NUM,arr_len));
        }
        return res;
    }

    static int getNumOfZhi(int num){
        if(isPrime(num)){
            if(num!=1){return 1;}
            return 0;
        }
        int count = 0;
        for(int i =2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                num/=i;
            }
            count++;
        }
        if(num!=1){
            count++;
        }
        return count;
    }

    private static boolean isPrime(int number){
        for(int i = 2 ;i<Math.sqrt(number);i++){
            if(number%i==0){return false;}
        }
        return true;
    }

}
