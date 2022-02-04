package 回溯法;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class T90 {

    @Test
    public void test(){
        subsetsWithDup(new int[]{1,2,2,3});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums,0,new ArrayList<Integer>());
        return res;
    }


    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void backTrace(int[] nums , int idx, List<Integer> list_now){
        res.add(new ArrayList<Integer>(list_now));
        for(int i = idx ; i < nums.length ; i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            else
                {
                list_now.add(nums[i]);
                backTrace(nums,i+1,list_now);
                list_now.remove((Integer)nums[i]);
            }
        }
    }
}
