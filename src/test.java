import org.junit.Test;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class test {

    public interface A{
        void e();
    }

    public class dd implements A{
        @Override
        public void e(){}
    }

    @Test
    public void a(){

    }

    void print(int v){
        if(v!=0){
            for(int i = 1;i<=v;i++){
                System.out.print(v);
            }
            print(v-1);
        }
    }



    public class Forest implements Serializable {
        private Tree tree = new Tree();
    }
    class Tree{

    }

    public class Base implements Serializable{
        public Base(){
            System.out.println("test");
        }
    }
}







