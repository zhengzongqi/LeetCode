package 动态规划;

import org.junit.Test;

import java.util.Random;

public class T334 {
    @Test
    public void test(){
        Random r = new Random();
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(r.nextInt(3));
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
    public boolean increasingTriplet(int[] nums) {
        //dp[x]表示递增序列长度为x+1的子序列中，末尾元素最小的那个数
        int[] dp = new int[3];
        dp[0] = nums[0];
        boolean isupdate = false;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>dp[1]&&isupdate==true){
                return true;
            }
            if(nums[i]>dp[0]){
                dp[1] = nums[i];
                isupdate = true;
            }
            else{
                dp[0]=nums[i];
            }
        }
        return false;
    }
}
