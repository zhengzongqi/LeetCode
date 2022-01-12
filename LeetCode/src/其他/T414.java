package 其他;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class T414 {
    @Test
    public void test(){
        //System.out.println(thirdMax( new int[]{1,1,2}));

        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> a1 =  new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        a1.add(1);
        a1.add(1);
        a1.add(2);
        a1.remove(new Integer(1));
        a2.add(2);
        set.add(a1);
        set.add(a2);
        System.out.println(a1);
    }
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }
}
