package 其他.排序;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Offer45 {

    @Test
    public void test(){

    }
    public String minNumber(int[] nums) {
        mycompartor c = new mycompartor();
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,c);
        StringBuilder res = new StringBuilder();
        for(String s:strs){
            res.append(s);
        }
        return res.toString();
    }


    public class mycompartor implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return  (o1+o2).compareTo(o2+o1);
        }

    }
}
