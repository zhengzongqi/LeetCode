package 回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    @Test
    public void test(){
        subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0,new ArrayList<Integer>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void backTrace(int[] nums , int idx, List<Integer> list_now){
        res.add(new ArrayList<Integer>(list_now));

        for(int i = idx ; i < nums.length ; i++){
            list_now.add(nums[i]);
            backTrace(nums,i+1,list_now);
            list_now.remove((Integer)nums[i]);
        }
    }
}
