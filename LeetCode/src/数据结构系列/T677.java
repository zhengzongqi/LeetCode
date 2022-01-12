package 数据结构系列;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T677 {

    @Test
    public void test(){
        MapSum s = new MapSum();
        s.insert("appled",2);
        System.out.println(s.sum("ap"));
        s.insert("apple",3);
        s.insert("apple",2);
        System.out.println(s.sum("a"));
    }
    //字典树
    class MapSum {

        Tire root ;

        public MapSum() {
            root = new Tire();
        }

        public void insert(String key, int val) {
            Tire t = root;

            List<Tire> road = new ArrayList<>();
            for(int i = 0 ; i<key.length();i++){
                char c = key.charAt(i);
                int idx = c-'a';
                if(t.child[idx]==null){
                    t.child[idx] = new Tire();
                }
                road.add(t.child[idx]);
                t=t.child[idx];
                t.num+=val;
            }
            if(t.over==false){
                t.over = true;
                t.prenum = val;
            }
            else{
                int pre = t.prenum;
                for(Tire tire:road){
                    tire.num -=pre;
                }
                t.prenum = val;
            }
        }

        public int sum(String prefix) {
            Tire t = root;
            for(int i = 0 ; i<prefix.length();i++){
                char c = prefix.charAt(i);
                int idx = c-'a';
                if(t.child[idx]==null){
                    return 0;
                }
                t=t.child[idx];
            }
            return t.num;
        }


        class Tire{
            public Tire[] child;
            public int num;
            public int prenum;
            public boolean over;
            public Tire(){
                num = 0;
                over = false;
                child = new Tire[26];
            }
        }
    }

}
