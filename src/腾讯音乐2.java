import org.junit.Test;

import java.util.*;

public class 腾讯音乐2 {
    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(1);
        System.out.println(minMax((ArrayList<Integer>) list,3,2));
    }
    public int minMax (ArrayList<Integer> a, int k, int x) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(Integer i : a){
            queue.offer(i);
        }
        for(int i = 0 ;i<k;i++){
            int ii = queue.poll();
            ii -= x;
            queue.offer(ii);
        }
        return queue.poll();
    }

    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
}
