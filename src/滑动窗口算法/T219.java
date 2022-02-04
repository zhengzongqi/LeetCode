package 滑动窗口算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T219 {
    @Test
    public void test(){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,1},1));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1||k==0){return false;}
        Map<Integer,Integer> map = new HashMap<>();
        int st = 0;
        int ed = k;
        for(int i = 0 ;i<=k;i++){
            if(i>=nums.length){return false;}
            int count = map.getOrDefault(nums[i],0)+1;
            if(count==2){
                return true;
            }
            map.put(nums[i],count);
        }
        for(int i =ed+1;i<nums.length;i++){
            int stcount = map.get(nums[i-k])-1;
            if(stcount==0){map.remove(nums[i-k-1]);}
            else{map.put(nums[i-k],stcount);}

            int edcount = map.getOrDefault(nums[i],0)+1;
            if(edcount>=2){return true;}
            else{map.put(nums[i],edcount);}
        }

        return false;
    }
}
