package 数学方法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer62 {
    @Test
    public void test(){
        System.out.println(lastRemaining2(70866,116922));
    }

    //接近超时
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {
        if(n==1){
            return 0;
        }
        int idx = 0;
        for(int i = 2;i<=n;i++){
            idx=(idx+m)%i;
        }
        return idx;
    }

}
