package 其他;

import java.util.Arrays;

public class T1913 {
    public int maxProductDifference(int[] nums) {
        int[] temp = new int[]{nums[0],nums[1],nums[2],nums[3]};
        Arrays.sort(temp);
        int min1 = temp[0];
        int min2 = temp[1];
        int max1 = temp[3];
        int max2 = temp[2];
        for(int i = 4;i<nums.length;i++){
            if(nums[i]>max1){
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i]>max2){
                max2 = nums[i];
            }
            else if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i]<min2){
                min2 = nums[i];
            }
        }
        return (max1*max2) - (min1*min2);
    }
}
