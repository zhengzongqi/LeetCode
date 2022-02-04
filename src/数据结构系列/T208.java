package 数据结构系列;

import java.util.HashMap;
import java.util.Map;

public class T208 {



    class Trie {

        Map<Character,Trie> map;//26个子树
        Character cha;
        boolean isend;
        public Trie() {
            map = new HashMap<>();
            isend = false;
        }

        public void insert(String word) {
            if(word==""){
                isend=true;
                return;
            }
            char c = word.charAt(0);
            if(map.get(c)==null){
                Trie t = new Trie();
                map.put(c,t);
                map.get(c).insert(word.substring(1));
            }
            else{
                map.get(c).insert(word.substring(1));
            }
        }

        public boolean search(String word) {
            if(isend==true&&word.length()==1){
                return true;
            }
            char c = word.charAt(0);
            if(map.get(c)==null){
                return false;
            }
            else{
                return map.get(c).search(word.substring(1));
            }
        }

        public boolean startsWith(String prefix) {
            if(prefix==""){
                return true;
            }
            char c = prefix.charAt(0);
            if(map.get(c)==null){
                return false;
            }
            else{
                return map.get(c).startsWith(prefix.substring(1));
            }
        }
    }
}
