package STL;

import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.*;

public class test {
    @Test
    public void test(){
        HashMap<Integer,String> map = new LinkedHashMap(10, (float) 0.75);
        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(4,"a");
        map.get(2);
        map.put(5,"a");
        map.put(6,"a");
        Iterator i = map.keySet().iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
