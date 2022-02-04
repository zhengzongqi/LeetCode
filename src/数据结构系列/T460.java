package 数据结构系列;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class T460 {


    @Test
    public void test(){
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.put(3,3);
        lfuCache.get(1);
    }
    /**
     * 要实现的功能：
     * 1.调用get(key)方法，返回key对应的value;
     * 2.调用put或者get方法，要把当前的key-value对应的freq+1;
     * 3.put(key,value)时，如果缓存没满，就加入，如果缓存满了，就删除freq最小的key,如果有多个key的freq相同,删除最近最久未使用的那个key；
     *
     * 对于1，需要一个hashmap1存储key-value的映射；
     * 对于2，需要一个hashmap2存储key-freq的映射；
     * 对于3，没满的时候直接更新hashmap1和hashmap2,如果满了，需要一个freq-key的hashmap3,但是可能多个key的freq相同，因此需要一个freq-key[]的映射；
     *       同时，freq相同的所有key需要有时序关系，因此可以用LinfedHashSet来存储key[]（使用LinkedList的话不能快速删除）；
     */



    class LFUCache {

        HashMap<Integer,Integer> KeyToVal;
        HashMap<Integer,Integer> KeyToFreq;
        HashMap<Integer, LinkedHashSet<Integer>> FreqToKeys;
        int cache;
        int minFreq;
        public LFUCache(int capacity) {
            KeyToVal = new HashMap<>();
            KeyToFreq = new HashMap<>();
            FreqToKeys = new HashMap<>();
            cache = capacity;
            minFreq =0;
        }

        public int get(int key) {
            if(!KeyToVal.containsKey(key)){
                return -1;
            }
            //增加key对应的freq
            increaseFreq(key);
            return KeyToVal.get(key);
        }

        public void put(int key, int value) {
            if(cache==0){
                return ;
            }
            if(KeyToVal.containsKey(key)){
                KeyToVal.put(key,value);
                increaseFreq(key);
            }
            else{
                //缓存没满
                if(cache>KeyToVal.size()){
                    KeyToVal.put(key,value);
                    KeyToFreq.put(key,1);
                    FreqToKeys.putIfAbsent(1,new LinkedHashSet<>());
                    FreqToKeys.get(1).add(key);
                    minFreq = 1;
                }
                //缓存满了
                else{
                    removeMinFreqKey();
                    KeyToVal.put(key,value);
                    KeyToFreq.put(key,1);
                    FreqToKeys.putIfAbsent(1,new LinkedHashSet<>());
                    FreqToKeys.get(1).add(key);
                    minFreq = 1;
                }
            }
        }


        public void increaseFreq(int key){
            int freq = KeyToFreq.get(key);
            KeyToFreq.put(key,freq+1);
            FreqToKeys.get(freq).remove(key);
            FreqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
            FreqToKeys.get(freq+1).add(key);
            //如果freq对应的列表空了,就移除掉
            if(FreqToKeys.get(freq).isEmpty()){
                FreqToKeys.remove(freq);
                //如果这个移除掉的freq恰好是minFreq,就更新minFreq
                if(freq == minFreq){
                    minFreq++;
                }
            }
        }

        public void removeMinFreqKey(){
            LinkedHashSet min = FreqToKeys.get(minFreq);
            int deleteKey = (int) min.iterator().next();
            min.remove(deleteKey);
            if(min.isEmpty()){
                //按理来说这里需要更新minFreq的，但是实际上不需要，因为removeMinFreqKey()只在添加新的键值对时才会调用，既然是添加新的键值对，那么minFreq肯定是1
                FreqToKeys.remove(minFreq);
            }
            KeyToVal.remove(deleteKey);
            KeyToFreq.remove(deleteKey);
        }


    }


}
