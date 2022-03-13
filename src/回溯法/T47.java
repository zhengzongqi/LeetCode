package 回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {

    @Test
    public void test(){
        System.out.println(permuteUnique(new int[]{1,1,3}));
    }
    List<List<Integer>> res ;
    int len;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        res = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>(),new int[len]);
        return res;
    }


    public void backTrack(int[] nums,int idx,List<Integer> record,int[] vis){
        if(record.size()==len){
            res.add(new ArrayList<>(record));
            return;
        }
        for(int i = 0;i<len;i++){
            if((i>0&&nums[i]==nums[i-1]&&vis[i-1]==0)|| vis[i]==1){
                continue;
            }
            vis[i] = 1;
            record.add(nums[i]);
            backTrack(nums,idx+1,record,vis);
            record.remove(record.size()-1);
            vis[i] = 0;
        }
    }

}
