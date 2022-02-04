package 其他;

import java.util.Arrays;

public class T453 {



    //n-1个数+1；相当于有1个数-1；理解成每次一个数-1，所有数字全部变成最小数所需要的次数
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int minval = nums[0];
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            res +=nums[i]-minval;
        }
        return res;
    }
}
