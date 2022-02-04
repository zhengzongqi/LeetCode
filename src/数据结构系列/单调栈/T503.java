package 数据结构系列.单调栈;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T503 {
    @Test
    public void test(){
        nextGreaterElements(new int[]{1,2,1});
    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] numsdouble = new int[len*2];
        for(int i = 0 ;i<len;i++){
            numsdouble[i] = nums[i];
            numsdouble[i+len] = nums[i];
        }
        Deque<Integer> stack = new LinkedList<Integer>();

        int[] res = new int[len];
        for(int i = len*2-1;i>=0;i--){
            while(stack.size()!=0&&stack.peek()<=numsdouble[i]){
                stack.poll();
            }
            if(i<len){
                if(stack.size()==0){
                    res[i] = -1;
                }
                else{
                    res[i] = stack.peek();
                }

            }
            stack.push(numsdouble[i]);
        }
        return res;

    }
}
