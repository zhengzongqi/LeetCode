package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1218 {
    @Test
    public void test(){
        System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        for(int i = 0 ; i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i]-difference,0)+1);
            max = Math.max(max,map.get(arr[i]));
        }
        return max;
    }
}

