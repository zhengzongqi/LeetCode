package 数据结构系列.单调队列;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {


    class MaxQueue {

        Deque<Integer> queue_max;
        Deque<Integer> queue;
        public MaxQueue() {
            queue_max = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            if(queue_max.isEmpty()){
                return -1;
            }
            return queue_max.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!queue_max.isEmpty()&&queue_max.peekLast()<value){
                queue_max.pollLast();
            }
            queue_max.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }
            int val = queue.poll();
            if(queue_max.peek()==val){
                queue_max.poll();
            }
            return val;
        }
    }
}
