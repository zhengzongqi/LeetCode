import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    @Test
    public void test1(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        for(int i = 0;i<13;i++){
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i));
        }
        list1.remove(String.valueOf(2));
        list2.remove(String.valueOf(2));
    }

}
