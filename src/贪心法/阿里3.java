package 贪心法;

import java.util.Scanner;

public class 阿里3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] nums = new double[n];
        for(int i = 0;i<n;i++){
            int AA = sc.nextInt();
            int BB = sc.nextInt();
            int temp = sc.nextInt();
            double k = 0;
            if(AA==0){
                k=99;
            }
            else{
                k=AA/BB;
            }
            nums[i] = k;
        }
        System.out.println(dfs(nums,0,0,new boolean[n]));
    }

    public static int count(double[] nums,boolean[] temp){
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j =i+1;j< nums.length;j++){
                if(nums[i]!=nums[j]&&temp[i]!=temp[j]){
                    res++;
                }
            }
        }
        return res;
    }

    public static int dfs(double[] nums,int i ,int res,boolean[] temp){
        if(i== nums.length){
            return Math.max(res,dfs(nums,i+1,res,temp));
        }
        else{
            res = Math.max(res,dfs(nums,i+1,res,temp));
            temp[i] = true;
            res = Math.max(res,dfs(nums,i+1,res,temp));
            temp[i] = false;
            return res;
        }
    }
}
