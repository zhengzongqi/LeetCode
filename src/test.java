import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    static volatile Integer suo = 0;

    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,10,0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20));
        Future future = poolExecutor.submit(new c());

    }

    static class a implements Runnable{

        @Override
        public void run() {
            try {
                synchronized (suo){
                    System.out.println("a进来了");
                    Thread.sleep(2000);
                    System.out.println("a结束了");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static class b implements Runnable{

        @Override
        public void run() {
            try {
                synchronized (suo){
                    System.out.println("b进来了");
                    System.out.println("b结束了");
                    suo.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class c implements Callable{

        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return 123;
        }
    }


}
