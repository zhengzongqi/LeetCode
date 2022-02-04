package JVM;

import java.util.Random;

public class Test3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0;i<2;i++){
            Thread t = new Thread(new MyThread(), String.valueOf(i));
            t.start();
        }
    }

    static class MyThread2 implements Runnable{
        private  int ticket = 5;
        public void run(){
            while(true){
                System.out.println("Runnable ticket = " + ticket--);
                if(ticket < 0){
                    break;
                }
            }
        }
    }

    static class MyThread extends Thread{
        private static volatile   int ticket = 100;
        public void run(){
            while(true){
                System.out.println("Thread ticket = "+ this.getName()+" " + ticket--);
                try {
                    Thread.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(ticket < 0){
                    break;
                }
            }
        }
    }
}

