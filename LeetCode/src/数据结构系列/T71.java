package 数据结构系列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T71 {
    @Test
    public void test(){
        System.out.println(simplifyPath("/x//.//"));
    }

    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList<>();
        for(int i = 1;i<path.length();i++){
            while(i<path.length()&&path.charAt(i)=='/'){
                i++;
            }
            String now = "";
            while(i<path.length()&&path.charAt(i)!='/'){
                now+=path.charAt(i);
                i++;
            }
            if(now.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(now.equals(".")){

            }
            else{
                stack.push(now);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        if(res.length()==0){
            res='/'+res;
        }
        else if(res.charAt(0)!='/'){
            res='/'+res;
        }
        if(res.length()>1&&res.charAt(res.length()-1)=='/'){
            res = res.substring(0,res.length()-1);
        }
        return res;
    }
}
