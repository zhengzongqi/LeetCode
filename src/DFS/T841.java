package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T841 {
    @Test
    public void test(){
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        List<Integer> c = new ArrayList<>();
        c.add(3);
        List<Integer> d = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        System.out.println(canVisitAllRooms(l));
    }

    Set<Integer> lockroom;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        lockroom = new HashSet<Integer>();
        for(int i =0;i<rooms.size();i++){
            lockroom.add(i);
        }
        lockroom.remove(0);
        collectkeys(0,rooms);
        return lockroom.size()==0?true:false;
    }

    public void collectkeys(int roomnumber,List<List<Integer>> rooms){
        List<Integer> keys = rooms.get(roomnumber);
        for(int i = 0;i<keys.size();i++){
            int key = keys.get(i);
            if(lockroom.contains(key)){
                lockroom.remove((Integer)key);
                collectkeys(key, rooms);
            }

        }
    }
}
