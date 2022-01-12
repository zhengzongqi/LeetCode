import org.junit.Test;

public class JVM {
    @Test
    public void test(){
        while(true){
            m2();
        }
    }

    public void m1(){

    }
    public void m2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1();
    }
}
