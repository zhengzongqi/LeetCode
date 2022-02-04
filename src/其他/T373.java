package 其他;

import org.junit.Test;

import java.util.*;

public class T373 {
    @Test
    public void test(){
        System.out.println(kSmallestPairs(new int[]{1,2},new int[]{3},3));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Comparator<int[]> listComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]]+nums2[o1[1]])-(nums1[o2[0]]+nums2[o2[1]]);
            }};
        Queue<int[]> queue = new PriorityQueue<int[]>(listComparator);
        for(int i = 0 ;i<nums1.length;i++){
            int[] in = new int[]{i,0};
            queue.offer(in);
        }
        while(k-->0&&!queue.isEmpty()){
            int[] temp = queue.poll();
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums1[temp[0]]);
            l.add(nums2[temp[1]]);
            res.add(l);
            if(temp[1]+1<nums2.length){
                queue.offer(new int[]{temp[0],temp[1]+1});
            }
        }

        return res;
    }
}
