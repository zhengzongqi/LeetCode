package 动态规划;

public class T213 {

    //跟T198类似，多了一个限制就是第一个房子和最后一个房子不能同时偷
    //那么就取两遍动态规划，一个不包含最后一座房子，一个不包含第一个房子，最后结果就是两个动态规划结果的较大一方
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        //dp1[]不包括最后一座房子
        for(int i = 2 ;i<nums.length;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i-1],dp1[i-1]);
        }
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2]=nums[1];
        for(int i = 3 ;i<=nums.length;i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i-1],dp2[i-1]);
        }
        return Math.max(dp1[nums.length-1],dp2[nums.length]);
    }
}
