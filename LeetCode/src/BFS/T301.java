package BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T301 {

    @Test
    public void test(){
        System.out.println(removeInvalidParentheses("()()))()"));
    }


    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<String>();
        Set<String> curset = new HashSet<>();
        curset.add(s);
        while(true){
            for(String ss:curset) {
                if (isValid(ss)) {
                    res.add(ss);
                }
            }
            if(res.size()!=0){
                return res;
            }
            Set<String> temp = new HashSet<>();
            //对当前层级上的所有字符串进行遍历，对于一个长度为n的字符串，删除其任意位置的括号，生成多个长度为n-1的字符串（循环生成，有几个括号就生成几个），再放回surset中
            for(String ss:curset){
                for(int i = 0 ; i< ss.length();i++) {
                    if(ss.charAt(i)=='('||ss.charAt(i)==')'){
                        temp.add( ss.substring(0,i)+ss.substring(i+1,ss.length()));
                    }
                }
            }
            curset = temp;
        }

    }

    public List<String> res;

    private boolean isValid(String str) {
        char[] ss = str.toCharArray();
        int count = 0;

        for (char c : ss) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

}
