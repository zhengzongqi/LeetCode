package 其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new ArrayList<>();
        String[] s1_split = s1.split(" ");
        String[] s2_split = s2.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<s1_split.length;i++){
            String s = s1_split[i];
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(int i = 0;i<s2_split.length;i++){
            String s = s2_split[i];
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s : map.keySet()){
            if(map.get(s)==1){
                res.add(s);
            }
        }
        String[] res1 = new String[res.size()];
        res1 = res.toArray(res1);
        return  res1;
    }
}
