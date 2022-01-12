package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T638 {
    class testclass{
        int num1;
        int num2;
        public testclass(int a,int b){
            num1=a;
            num2=b;
        }
    }
    @Test
    public void test(){
        //map的key为list时
        Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        memo.put(list,10);
        list.add(3);
        memo.put(list,20);
        list.remove((Integer) 3);
        memo.put(list,30);
        System.out.println(memo.get(list));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        System.out.println(memo.get(list1));


        Map<testclass,Integer> map = new HashMap<>();
        testclass testclass1 = new testclass(1,2);
        map.put(testclass1,2);
        testclass1.num2 = 3;
        map.put(testclass1,1);
        System.out.println(map.get(testclass1));

        testclass1.num2 = 2;
        testclass testclass2 = new testclass(1,2);
        System.out.println(map.get(testclass2));




        ArrayList<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<Integer>(){{add(1);add(2);add(1);}});
        special.add(new ArrayList<Integer>(){{add(1);add(2);add(2);}});
        ArrayList<Integer> needs = new ArrayList<>();
        needs.add(2);
        needs.add(5);

        System.out.println(shoppingOffers(price,special,needs  ));
    }
    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, special, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; ++i) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for (int i = 0; i < n; ++i) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }

}
