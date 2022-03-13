package 数据结构系列;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Offer037 {
    @Test
    public void test(){
        Map<Integer,Integer> map = new HashMap<>();
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        Map.Entry entry = iterator.next();

        ConcurrentHashMapsdsds
                dsdsdsre
                eee
        //System.out.println(asteroidCollision(new int[]{-2,-2,1,-2}));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i<asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            }
            else if((stack.peek()<0&&asteroids[i]<0)||(stack.peek()>0&&asteroids[i]>0)||(stack.peek()<0&&asteroids[i]>0))
            {
                stack.push(asteroids[i]);
            }
            else
            {
                int weight = Math.abs(asteroids[i]);
                while(!stack.isEmpty()&&stack.peek()>0&&stack.peek()<weight){
                    stack.poll();
                }
                if(!stack.isEmpty()&&stack.peek()==weight){
                    stack.poll();
                }
                else if(!stack.isEmpty()&&stack.peek()>weight){}
                else {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length-1;i>=0;i--){
            res[i] = stack.poll();
        }
        return res;
    }
}
