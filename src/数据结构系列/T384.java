package 数据结构系列;

import org.junit.Test;

import java.util.*;

public class T384 {
    @Test
    public void test(){
        Solution s = new Solution(new int[]{1,2,3,4});
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
    }

    class Solution {

        int[] preview;
        int[] num;
        int len;
        Random r ;
        public Solution(int[] nums) {
            preview = Arrays.copyOf(nums,nums.length);
            len = nums.length;
            num = nums;
            r = new Random();
        }


        public int[] reset() {
            return preview;
        }

        public int[] shuffle() {
            for(int i = len-1;i>=0;i--){
                int a = r.nextInt(i+1);
                int aa = num[i];
                num[i] = num[a];
                num[a] = aa;

            }
            return num;
        }
    }


}
