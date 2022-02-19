package 数据结构系列.优先队列;

import org.junit.Test;

import java.util.PriorityQueue;

public class T1414 {
    @Test
    public void test(){
        System.out.println(findMinFibonacciNumbers(7));
    }

    public PriorityQueue<Integer> queue;
    public int findMinFibonacciNumbers(int k) {
        queue = new PriorityQueue<>( (a,b)->b-a );
        long prev1 = 1;
        long prev2 = 1;
        queue.add(1);
        while(prev2 <= k){
            long temp = prev2;
            prev2 = prev1+prev2;
            prev1 = temp;
            queue.add((int) prev2);
        }
        int remain = k;
        int res = 0;
        while(remain!=0){
            int maxval = queue.peek();
            if(maxval>remain){
                queue.poll();
            }
            else{
                remain -= maxval;
                res++;
            }
        }
        return res;
    }
}
