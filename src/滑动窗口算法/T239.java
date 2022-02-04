package 滑动窗口算法;

import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length==0){
                return new int[0];
            }
            int[] res = new int[nums.length+1-k];
            for(int i = 0 ; i<nums.length;i++){
                if(i<k-1){
                    queue_push(nums[i]);
                }
                else{
                    queue_push(nums[i]);
                    res[i-k+1] = queue_getmax();
                    queue_pop(nums[i-k+1]);
                }
            }
            return res;
        }

        Deque<Integer> queue = new LinkedList<Integer>();

        public void queue_push(int i){
            while(!queue.isEmpty()&&queue.peekLast()<i){
                queue.pollLast();
            }
            queue.offer(i);
        }

        public Integer queue_getmax(){
            return queue.peek();
        }

        public void queue_pop(int i){
            if(i==queue.peek()){
                queue.poll();
            }
        }
    }
}
