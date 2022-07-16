package 其他;

import java.util.Arrays;

public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int idx = 0;
        int len = nums.length;
        for(int i = 0;i<len;i++){
            if((i==len-1||nums[i]!=nums[i+1])&&(i==0||nums[i]!=nums[i-1])){
                res[idx++] = nums[i];
            }
        }
        return res;
    }
}
