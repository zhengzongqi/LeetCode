package 回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39 {
    @Test
    public void test(){
        System.out.println(combinationSum( new int[]{2},2));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backTrace(new ArrayList<Integer>(),0,candidates,target,candidates.length-1);

        return result;
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public void backTrace(List<Integer> arrays,int total,int[] candidates,int target,int idx){
        if(total==target){

            result.add(new ArrayList<>(arrays));
        }
        else if (total>target){
            return;
        }
        else{
            for(int i = idx ; i >=0;i--){
                arrays.add(candidates[i]);
                backTrace(arrays,total+candidates[i],candidates,target,i);
                arrays.remove(new Integer(candidates[i]));
            }
        }
    }
}
