package 其他;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class T1748 {
    @Test
    public void test(){
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
    }
    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Integer i : map.keySet()){
            if(map.get(i)==1){
                res += i;
            }
        }
        return res;
    }
}
