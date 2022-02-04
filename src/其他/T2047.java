package 其他;

import org.junit.Test;

public class T2047 {

    @Test
    public void test(){
        System.out.println(        countValidWords("cat and  dogs"));
    }

    public int countValidWords(String sentence) {
        String[] tokens = sentence.split(" ");
        int res = 0;
        for(String token : tokens){
            if(check(token)==true){
                res++;
            }
        }
        return res;
    }

    private boolean check(String token){
        int zimu = 0;
        int lianzifu = 0;
        int biaodian = 0;
        int lianzifuzimu = 0;
        int kongge = 0;
        for(int i =0;i<token.length();i++){
            char c = token.charAt(i);
            if(c == ' '){
                kongge++;
                continue;
            }
            if(c>='0'&&c<='9'){return false;}
            else if(c>='a'&&c<='z'){
                zimu++;
            }
            else if(c=='-'){
                if(zimu==0||lianzifu>=1){return false;}
                else{lianzifu++;lianzifuzimu = zimu;}
            }
            else{
                if(biaodian>=1||i!=token.length()-1||i==0){return false;}
                else{biaodian++;}
            }
        }

        if(lianzifuzimu==zimu&&lianzifu>0){
            return false;
        }
        if(kongge==token.length()){return false;}
        return true;
    }
}
