import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 美的 implements Cloneable {
    @Test
    public void test(){
Integer a = 1;
Integer b = a;
a = a++;
        System.out.println(a+b);
    }

    class test{
        private void test1(int a ,String s){
            a = 5;
            s ="111";
        }
    }
}
