package 数据结构系列.单调栈;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T739 {


    @Test
    public void test(){
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //Map<Integer,Integer> res = new HashMap<>();
        Deque<Integer> stack = new LinkedList<Integer>();


        for(int i = temperatures.length-1;i>=0;i--){
            int mark = 0;
            while(stack.size()!=0&&temperatures[stack.peek()]<=temperatures[i]){
                stack.poll();
            }
            if(stack.size()==0){
                res[i]=0;
            }
            else{
                res[i] =  stack.peek()-i;
            }
            stack.push(i);
        }

        return res;
    }
}
