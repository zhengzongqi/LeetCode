package 回溯法;

import org.junit.Test;

public class T494 {

    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    public int findTargetSumWays(int[] nums, int target) {
        backtrace(0,nums,0,target);
        return result;
    }

    int result = 0;
    //total:0-(idx-1)下标的数字和；
    //nums:整数数组
    //idx:当前回溯到的数组下标
    //target:目标值
    public void backtrace(int total,int[] nums,int idx,int target){
        if(idx==nums.length){
            if(total==target) {
                result++;
            }
        }
        else{
            //idx位置的数字取加号
            backtrace(total+nums[idx],nums,idx+1,target);
            backtrace(total-nums[idx],nums,idx+1,target);
        }
    }
}
