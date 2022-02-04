package 滑动窗口算法;

import org.junit.Test;

import java.util.*;

public class T31 {
    @Test
    public void test(){

//        int[] nums = new int[]{1,4,3,2};
//        nextPermutation(nums);

    }
    public void nextPermutation(int[] nums) {
        stack = new LinkedList<Integer>();
        stack.push(nums.length-1);
        NUMs = nums;

        int i ;
        for(i = nums.length-2;i>=0;i--) {
            int idx = stack_push(i);
            if (idx != -1) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        for(int j = i+1;j<nums.length;j++){
            for(int k = j;k<nums.length;k++){
                if(nums[j]>nums[k]){
                    int temp1 = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp1;
                }
            }
        }

        if(stack.size()==nums.length){
            Arrays.sort(nums);
        }
    }

    int[] NUMs;
    Deque<Integer> stack;
    public int stack_push(int idx){
        boolean ismax = true;
        int topidx = -1;
        while(!stack.isEmpty()&&NUMs[stack.peek()]>NUMs[idx]){
            ismax = false;
            topidx = stack.poll();
        }
        if(ismax==false){
            return topidx;
        }
        stack.push(idx);
        return -1;

    }
}
