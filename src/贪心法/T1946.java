package 贪心法;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class T1946 {

    @Test
    public void test(){
        System.out.println(maximumNumber("334111",new int[]{0,9,2,3,3,2,5,5,5,5}));
    }
    public String maximumNumber(String num, int[] change) {
        StringBuilder numcopy = new StringBuilder(num);
        Set<Integer> bigger = new HashSet<>();
        Set<Integer> nochange = new HashSet<>();
        for(int i =0;i<10;i++){
            if(change[i]>i){
                bigger.add(i);
            }
            if(change[i]==i){
                nochange.add(i);
            }
        }
        boolean hasmodify = false;
        for(int i = 0;i<num.length();i++){
            if(hasmodify==true){break;}
            int c = num.charAt(i) - '0';
            if(bigger.contains(c)){
                while(i<num.length()&&(bigger.contains(num.charAt(i)- '0')||nochange.contains(num.charAt(i)- '0'))){
                    numcopy.setCharAt(i, (char) (change[num.charAt(i)- '0']+'0'));
                    i++;
                    hasmodify = true;
                }
            }
        }

        return new String(numcopy);
    }
}
