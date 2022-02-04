package 双指针法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T18 {
    @Test
    public void test(){
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4){return res;}
        Arrays.sort(nums);
        int len =nums.length;
        for(int num1 = 0;num1<len-3;num1++){
            if(num1>0&&nums[num1]==nums[num1-1]){continue;}
            for(int num2 = num1+1;num2<len-2;num2++){
                if(num2>num1+1&&nums[num2]==nums[num2-1]){continue;}
                int target1 = target-nums[num1]-nums[num2];
                int num3 = num2+1;
                int num4 = len-1;
                while(num3<num4){
                    if(nums[num3]+nums[num4]==target1){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[num1]);
                        l.add(nums[num2]);
                        l.add(nums[num3]);
                        l.add(nums[num4]);
                        res.add(l);
                        num3++;
                        while(num3<num4&&nums[num3]==nums[num3-1]){num3++;}
                    }
                    else if(nums[num3]+nums[num4]<target1){
                        num3++;
                    }
                    else{
                        num4--;
                    }
                }
            }
        }
        return res;
    }
}
