package JVM;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class hello {
    public static void main(String[] args){
//        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
//        map.put(1,"q");
//        map.put(2,"qq");
//        map.get(2);
        app aa = new app();
        aa.a = 3;
        System.out.println(Unsafe.getUnsafe().compareAndSwapInt(aa,20,15,-1));


    }

    static class app {
        public int a;
        public app(){

        }
    }
}
