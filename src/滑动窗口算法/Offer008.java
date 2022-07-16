package 滑动窗口算法;

import org.junit.Test;

public class Offer008 {
    @Test
    public void test(){
        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int total = nums[0];
        while(left<nums.length){
            if(total>=target){
                minlen = Math.min(minlen,right-left+1);
                total-=nums[left];
                left++;
                if(left>=nums.length){break;}
            }
            else{
                right++;
                if(right>=nums.length){break;}
                total+=nums[right];
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}
