package 数据结构系列;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;

public class T146 {

    @Test
    public void test(){

    }

    class LRUCache {

        LinkedHashMap<Integer,Integer> map;
        int capacity;
        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){

                int value = map.get(key);
                map.remove(key);
                map.put(key,value);

                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.remove(key);
                map.put(key,value);
            }
            else if(map.size()<capacity){
                map.put(key,value);
            }
            else{
                int old = map.keySet().iterator().next();
                map.remove(old);
                map.put(key,value);
            }
        }
    }

}
