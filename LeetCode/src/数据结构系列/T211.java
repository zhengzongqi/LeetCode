package 数据结构系列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T211 {


    @Test
    public void test(){
        String s = "a";
        String ss = s.substring(1);
        System.out.println(ss);
    }




    class WordDictionary {

        Map<Integer,List<String>> map;
        public WordDictionary() {
            map = new HashMap<>();
        }

        public void addWord(String word) {
            int len = word.length();
            if(map.get(len)==null){
                List<String> s =new ArrayList<>();
                s.add(word);
                map.put(len,s);
            }
            else{
                map.get(len).add(word);
            }
        }

        public boolean search(String word) {

            int len = word.length();
            List<String> dict = map.get(len);
            if(dict==null){
                return false;
            }
            for(int i = 0;i<dict.size();i++){
                String s = dict.get(i);
                if(s.length()!=word.length()){
                    continue;
                }
                boolean b = true;
                for(int j = 0;j<s.length();j++){
                    if(word.charAt(j)!=s.charAt(j)&&word.charAt(j)!='.'){
                        b=false;
                        break;
                    }
                }
                if(b==true){
                    return true;
                }
            }

            return false;
        }
    }
}
