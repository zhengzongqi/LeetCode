package 数据结构系列.优先队列;

import org.junit.Test;

import java.util.*;

public class T2034 {

    @Test
    public void test(){
    }


    //用优先队列
    class StockPrice {
        class Price{
            public int price;
            public boolean isold;

            public Price(int p){
                price = p;
                isold = false;
            }
        }

        PriorityQueue<Price> maxqueue;
        PriorityQueue<Price> minqueue;
        Map<Integer,Price> map;
        int maxtime;

        public StockPrice() {
            Comparator<Price> comparator = new Comparator<Price>(){
                //负数代表左值小于右值，排在前面
                //正数代表左值大于右值，排在后面
                @Override
                public int compare(Price c1, Price c2) {
                    return (c2.price - c1.price);
                }
            };
            maxqueue = new PriorityQueue<Price>(comparator);
            minqueue = new PriorityQueue<>((p1, p2) -> p1.price - p2.price);
            map = new HashMap<>();
            maxtime = Integer.MIN_VALUE;
        }

        public void update(int timestamp, int price) {
            Price p;
            if(map.containsKey(timestamp)){
                //老数据就把老的price拿出来置为old，这样队列里面也变成了old，然后再放一个新数据进队列
                p = map.get(timestamp);
                p.isold = true;
                Price pp = new Price(price);
                map.put(timestamp,pp);
                p = new Price(price);
                maxqueue.offer(pp);
                minqueue.offer(pp);
            }
            else{
                //新数据就把它放进优先队列里面
                p = new Price(price);
                maxqueue.offer(p);
                minqueue.offer(p);
                map.put(timestamp,p);
            }
            if(maxtime<timestamp){maxtime=timestamp;}
        }

        public int current() {
            return map.get(maxtime).price;
        }

        public int maximum() {
            while(!maxqueue.isEmpty()){
                if(maxqueue.peek().isold==false){
                    break;
                }
                else{
                    maxqueue.poll();
                }
            }
            return maxqueue.peek().price;
        }

        public int minimum() {
            while(!minqueue.isEmpty()){
                if(minqueue.peek().isold==false){
                    break;
                }
                else{
                    minqueue.poll();
                }
            }
            return minqueue.peek().price;
        }


    }

    //用TreeMap
    class StockPrice1 {
        int maxTimestamp;
        HashMap<Integer, Integer> timePriceMap;
        //《价格，价格出现次数》
        TreeMap<Integer, Integer> prices;

        public StockPrice1() {
            maxTimestamp = 0;
            timePriceMap = new HashMap<Integer, Integer>();
            prices = new TreeMap<Integer, Integer>();
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(maxTimestamp, timestamp);
            int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
            timePriceMap.put(timestamp, price);
            if (prevPrice > 0) {
                prices.put(prevPrice, prices.get(prevPrice) - 1);
                if (prices.get(prevPrice) == 0) {
                    prices.remove(prevPrice);
                }
            }
            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return timePriceMap.get(maxTimestamp);
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }

}
