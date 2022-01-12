package 其他;

import org.junit.Test;

public class T686 {
    @Test
    public void test(){
        System.out.println(repeatedStringMatch("abcd",
                "cdabcdab"));
    }
    public int repeatedStringMatch(String a, String b) {
        String mult = "";
        int maxtimes = b.length()/a.length()+2;
        for(int i = 0;i<=maxtimes;i++){
            if(mult.indexOf(b)!=-1){
                return i;
            }
            mult+=a;
        }
        return -1;
    }
}
