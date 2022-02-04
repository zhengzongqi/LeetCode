package 其他;

import org.junit.Test;

import java.util.*;

public class T496 {
    @Test
    public void test(){
        System.out.println(nextGreaterElement1(new int[]{4,1,2},new int[]{1,3,4,2}));

        Deque<Integer> lin = new LinkedList<>();

    }

    //暴力
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[nums1.length];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                k++;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }

    //使用栈+哈希表
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(nums2[nums2.length-1]);
        map.put(nums2[nums2.length-1],-1);
        for(int i = nums2.length-2;i>=0;i--){
            while(!stack.isEmpty()&&(int)stack.peek()<nums2[i]){
                stack.poll();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i = 0 ; i < res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
