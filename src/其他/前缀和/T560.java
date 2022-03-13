package 其他.前缀和;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    @Test
    public void test(){
        System.out.println(subarraySum(new int[]{1,3,2,-1,0,1,-1,1,1},3));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, len = nums.length, sum = 0;
        for(int i = 0; i < len; ++i){
            sum += nums[i]; // 前缀和包含当前数字
            if(sum == k) ++ans;
            if(map.containsKey(sum-k)) ans += map.get(sum-k);
            // map记录前缀和
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
