package 数据结构系列.堆;

import org.junit.Test;

import java.util.*;

public class Offer49 {


    @Test
    public void test(){
        System.out.println(nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        Character.valueOf((char) ('a'+1));
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
