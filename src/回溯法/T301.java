package 回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T301 {

    @Test
    public void test(){
        System.out.println(removeInvalidParentheses("()())()"));
    }


    Set<String> res;

    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>();
        int leftcount = 0;
        int rightcount = 0;



        //一开始想的是先确定要删除左括号还是右括号，并且确定删除多少个，于是用的这种方法，使用remove存储要删除的数量,remove<0代表要删除左括号，大于0要删除有括号
        //但是这样的话没有办法处理这种情况：“)(”,"))((",这样的话remove=0；程序判断不需要删除
        //因此还是需要分别记录需要删除几个右括号，几个左括号
//        for(int i = 0 ; i < s.length();i++){
//            if(s.charAt(i)=='('){
//                leftcount++;
//            }
//            else if(s.charAt(i)==')'){
//                rightcount++;
//            }
//        }
//        int remove = rightcount-leftcount;



        //统计异常的左右括号数量
        int removel = 0;  //要删除的左括号数量
        int remover = 0;   //要删除的右括号数量

        int mark1 = 0;    //用来标记当前异常的左括号有多少个，遍历时遇到左括号加一，遇到右括号减一（跟mark一样）；但是mark1永远大于等于0，如果mark=-1,将其变为0；
                          //这样的话，异常的右括号不会影响对异常左括号的统计（mark1=-1时说明当前的右括号是异常的）
        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)=='('){
                mark1++;
            }
            else if(s.charAt(i)==')'){
                mark1--;
                if(mark1<0){
                    remover++;
                    mark1=0;
                }
            }
        }
        removel = mark1;




        backTrace(s,removel,remover,0);

        return new ArrayList<>(res);
    }

    private void backTrace(String s,int removel,int remover,int idx){
        if(removel==0&&remover==0&&isVaild(s)){
            res.add(s);
            return;
        }

        for(int i = idx ; i <s.length();i++){
            if(s.charAt(i)=='('){
                backTrace(s.substring(0,i)+s.substring(i+1,s.length()),removel-1,remover,i);
            }
            else if(s.charAt(i)==')'){
                backTrace(s.substring(0,i)+s.substring(i+1,s.length()),removel,remover-1,i);
            }
        }
//
//        if(remove<0){
//            for(int i = idx ; i <s.length();i++){
//                if(s.charAt(i)=='('){
//                    backTrace(s.substring(0,i)+s.substring(i+1,s.length()),remove+1,i);
//                }
//            }
//        }
//        else if(remove>0){
//            for(int i = idx ; i <s.length();i++){
//                if(s.charAt(i)==')'){
//                    backTrace(s.substring(0,i)+s.substring(i+1,s.length()),remove-1,i);
//                }
//            }
//        }
    }

    private boolean isVaild(String s){
        int mark = 0;
        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)=='('){
                mark++;
            }
            else if(s.charAt(i)==')'){
                mark--;
            }
            if(mark<0){
                return false;
            }
        }
        return mark==0;
    }


}
