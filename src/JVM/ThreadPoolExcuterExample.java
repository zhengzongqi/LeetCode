package JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolExcuterExample {
    public static void main(String[] args) throws Exception{
        List<Integer> list = new ArrayList<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,1L, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));
        for(int i = 0;i<10;i++){
           Future future = executor.submit( new MyCallable(i)) ;
           list.add((Integer) future.get());
        }
        System.out.println(list);
    }



    static class MyRunnable implements Runnable{
        private int name ;
        public  MyRunnable(int s){
            name = s;
        }
        @Override
        public void run() {
            System.out.println(name);
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyCallable implements Callable<Integer>{

        int name ;
        public  MyCallable(int s){
            name = s;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println(name);
            Thread.sleep(1000);
            return name;
        }
    }
}
