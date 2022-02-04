package 动态规划;

import org.junit.Test;

import java.util.Arrays;

public class T10 {
    @Test
    public void test(){
        System.out.print(isMatch("aab","c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        return dp(s,p,0,0);
    }


    public boolean dp(String s,String p,int i,int j){
        //如果j走到底了，i也走到底了，说明能匹配，如果i还没有，返回false;
        if(j==p.length()){
            return i==s.length();
        }
        //如果已走到底了，看一下p[j...]能不能匹配空串，可以的话说明能匹配，否则不能
        if(i==s.length()){
            if((p.length()-j)%2==1){
                return false;
            }
            for(int jj=j;jj+1<p.length();jj+=2){
                if(p.charAt(jj+1)!='*'){return false;}
            }
            return true;
        }

        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
            if(j<p.length()-1&&p.charAt(j+1)=='*'){
                //试着匹配0次或者多次
                //匹配0次：p去掉‘a*’或者‘.*’这两个字符，从s当前字符接着匹配，例如s="abc",p="*aabc"
                //匹配多次，等于是s的当前字符已经匹配好了，p保留‘a*’或者‘.*’这两个字符，从s的下一位字符接着匹配例如s="aaaaabc",p="a*bc"
                return dp(s,p,i,j+2)||dp(s,p,i+1,j);
            }
            else{
                //普通的匹配一次
                return dp(s,p,i+1,j+1);
            }
        }
        else{
            if(j<p.length()-1&&p.charAt(j+1)=='*'){
                //进入到这里说明s的当前字符跟p对应不上，但是由于‘a*’可以匹配0次，于是从p[j+2]开始看是否能匹配成功，例如s=“abcd”,p=“*eabcd”这种情况
                return dp(s,p,i,j+2);
            }
            else{
                return false;
            }
        }
    }


}
