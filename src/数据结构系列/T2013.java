package 数据结构系列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2013 {
    @Test
    public void test() throws ClassNotFoundException {
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c.getClass().toString());
        DetectSquares d = new DetectSquares();
        d.add(new int[]{3,10});
        d.add(new int[]{11,2});
        d.add(new int[]{3,2});
        System.out.println(d.count(new int[]{11,10}));
        System.out.println(d.count(new int[]{14,8}));
        d.add(new int[]{11,2});
        System.out.println(d.count(new int[]{11,10}));
    }

    class DetectSquares {

        Map<Integer, Map<Integer,Integer>> xpos;

        public DetectSquares() {
            xpos = new HashMap<>();

        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            if(xpos.containsKey(x)){
                Map<Integer,Integer> map = xpos.get(x);
                map.put(y,map.getOrDefault(y,0)+1);
            }
            else{
                Map<Integer,Integer> map = new HashMap<>();
                map.put(y,1);
                xpos.put(x,map);
            }
        }

        public int count(int[] point) {
            int x = point[0];
            int y = point[1];
            if(!xpos.containsKey(x)){
                return 0;
            }
            Map<Integer,Integer> xmap = xpos.get(x);
            int res = 0;
            for(int yy: xmap.keySet()){
                if(yy==y){continue;}
                int len = Math.abs(yy-y);
                int minpointcount = xmap.get(yy);
                if(xpos.containsKey(x-len)){
                    Map<Integer,Integer> leftmap = xpos.get(x-len);
                    if(leftmap.containsKey(yy)&& leftmap.containsKey(y)){
                        minpointcount *= leftmap.get(yy);
                        minpointcount *= leftmap.get(y);
                        res +=minpointcount;
                    }
                }
                minpointcount = xmap.get(yy);
                if(xpos.containsKey(x+len)){
                    Map<Integer,Integer> rightmap = xpos.get(x+len);
                    if(rightmap.containsKey(yy)&& rightmap.containsKey(y)){
                        minpointcount *= rightmap.get(yy);
                        minpointcount *= rightmap.get(y);
                        res +=minpointcount;
                    }
                }
            }
            return res;
        }
    }

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
}
