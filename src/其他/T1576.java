package 其他;

import org.junit.Test;

public class T1576 {


    @Test
    public void test(){
        System.out.println(modifyString("afd?esd???"));
    }

    public String modifyString(String ss) {
        StringBuilder s = new StringBuilder(ss);
        char[] c = new char[]{'a','b','c'};
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i)=='?'){
                if(i==0){
                    if(s.length()==1){
                        s.setCharAt(i,'a');
                    }
                    else{
                        char next = s.charAt(i+1);
                        if(next=='?'){
                            s.setCharAt(i,'a');
                        }
                        else{
                            s.setCharAt(i, getNext(next));
                        }
                    }
                }
                else if(i==s.length()-1){
                    char pre = s.charAt(i-1);
                    s.setCharAt(i, getNext(pre));
                }
                else{
                    char pre = s.charAt(i-1);
                    char next = s.charAt(i+1);
                    char cha = getNext(pre);
                    if(next=='?'){
                        s.setCharAt(i,cha);
                    }
                    else{
                        s.setCharAt(i,cha==next?getNext(cha):cha);
                    }
                }
            }
        }
        return  new String(s);
    }

    public char getNext(char a){
        if(a=='z'){
            return 'a';
        }
        return (char)(a+1);
    }
}
