package 滑动窗口算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438 {

    @Test
    public void test(){
        findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character,Integer> visited = new HashMap<Character,Integer>();
        Map<Character,Integer> window = new HashMap<Character,Integer>();
        for(int i = 0 ; i < p.length();i++){
            visited.put(p.charAt(i),visited.getOrDefault(p.charAt(i),0)+1);
        }

        int vaild = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            if(visited.containsKey(c)){
                if(window.get(c).equals(visited.get(c))){
                    vaild++;
                }
            }
            while(vaild==visited.size()){
                if(right-left == p.length()){
                    result.add(left);
                }
                char c_l = s.charAt(left);
                left++;
                window.put(c_l,window.get(c_l)-1);
                if(visited.containsKey(c_l)){
                    if(window.get(c_l)<visited.get(c_l)){
                        vaild--;
                    }
                }
            }
        }
        return result;


    }
}
