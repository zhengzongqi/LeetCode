package 双指针法;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class T15 {
    @Test
    public void test(){
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4,1,-1,1,0,0,0,3,4}));
    }


    //双指针(实际上还是三重循环)
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int p1 = 0 ; p1<len;p1++){
            if(p1>0&&nums[p1]==nums[p1-1]){
                continue;
            }
            int target = 0-nums[p1];
            for(int p2 = p1+1;p2<len;p2++){
                if(p2>p1+1&&nums[p2]==nums[p2-1]){
                    continue;
                }
                int p3 = len-1;
                while (nums[p3]+nums[p2]>target&&p2<p3){
                    p3--;
                }
                if(nums[p2]+nums[p3]==target&&p2<p3){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.add(nums[p3]);
                    result.add(list);
                }

            }
        }
        return result;
    }
    //双指针(二重循环，时间复杂度O(n^2))
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int p1 = 0 ; p1<len;p1++){
            if(p1>0&&nums[p1]==nums[p1-1]){
                continue;
            }
            int target = 0-nums[p1];
            int p3 = len-1;
            int p2 = p1+1;
            while(p2<p3){
                if(nums[p2]+nums[p3]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.add(nums[p3]);
                    result.add(list);
                    p2++;
                    while(nums[p2]==nums[p2-1]&&p2<p3){
                        p2++;
                    }
                }
                else if(nums[p2]+nums[p3]<target){
                    p2++;
                    while(p2>p1+1&&nums[p2]==nums[p2-1]&&p2<p3){
                        p2++;
                    }
                }
                else if(nums[p2]+nums[p3]>target){
                    p3--;
                    while(p2<p3&&nums[p2]+nums[p3]>target){
                        p3--;
                    }
                }
            }
        }
        return result;
    }

    //回溯（可能超时）
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums,new ArrayList<Integer>(),0,0);
        return result ;
    }

    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    //public Set<int[]> result = new HashSet<int[]>();

    public void backtrace(int[] nums,List<Integer> select,int value,int idx){
        if(select.size()>3){
            return;
        }
        if(select.size()==3&&value==0){
            List<Integer> tmp = new ArrayList<>(select);
            Collections.sort(tmp);
            if(!result.contains(tmp)){
                result.add(tmp);
            }
        }
        else{
            for(int i = idx ;i<nums.length;i++){

                select.add((Integer) nums[i]);

                backtrace(nums,select,value+nums[i],i+1);

                select.remove((Integer) nums[i]);
            }
        }
    }


}
