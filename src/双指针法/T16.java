package 双指针法;

import java.util.Arrays;

public class T16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int idx3 = 0;
        int res = nums[0]+nums[1]+nums[nums.length-1];
        for(idx3 = 0 ;idx3<nums.length;idx3++){
            int tar = target-nums[idx3];
            int idx1 = idx3+1;
            int idx2 = nums.length-1;
            while(idx1<idx2){
                int temp = nums[idx1]+nums[idx2];

                int t1 = temp+nums[idx3];
                res = Math.abs(target-t1)<Math.abs(target-res)?t1:res;
                if(temp==tar){
                    return target;
                }
                if(temp>tar){
                    idx2--;
                }
                else{
                    idx1++;
                }
            }
        }
        return res;
    }
}
