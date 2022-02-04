package JVM;

import sun.plugin.ClassLoaderInfo;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSExample {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{
        for(int i = 0;i<10;i++){
            Thread t = new Thread(new ThreadDemo(),String.valueOf(i));
            t.start();
        }
    }

    static class ThreadDemo implements Runnable {
        static Integer num = 20;

        public ThreadDemo() {

        }

        @Override

        public void run() {
            while (true){
                lock.lock();
                    System.out.println(num);
                    num--;
                    lock.unlock();
                    try {
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
