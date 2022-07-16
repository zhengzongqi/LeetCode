package DFS;
import org.junit.Test;

import java.util.*;

public class T2049 {

    @Test
    public void test(){
        System.out.println(countHighestScoreNodes(new int[]{-1,3,3,5,7,6,0,0}));
    }

    int[] childcount;
    List<Integer>[] child;
    public int countHighestScoreNodes(int[] parents) {
        int len = parents.length;
        childcount = new int[len];
        Arrays.fill(childcount,-1);
        child = new ArrayList[len];
        for(int i = 0;i<len;i++){
            child[i] = new ArrayList<>();
        }
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                if(parents[j] == i){
                    child[i].add(j);
                }
            }
        }
        DFS(0);

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<len;i++){
            int total = 1;
            for(int j = 0;j<child[i].size();j++){
                total*=childcount[child[i].get(j)];
            }
            if(child[i].size()==0){
                total = len-1;
            }
            else if(i!=0)
                total*=(childcount[0]-childcount[i]);
            map.put(total,map.getOrDefault(total,0)+1);
        }
        int max = -1;
        for(Integer i : map.keySet()){
            max = Math.max(max,i);
        }
        return map.get(max);

    }

    public int DFS(int n){
        int res = 1;
        if(childcount[n] != -1){
            return res;
        }
        for(int i = 0;i<child[n].size();i++){
            res += DFS(child[n].get(i));
        }
        if(childcount[n] == -1){
            childcount[n] = res;
        }
        return res;
    }
}
