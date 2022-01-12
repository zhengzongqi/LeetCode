package 其他;

import org.junit.Test;

import java.util.*;

public class T187 {

    @Test
    public void test(){
        System.out.println(findRepeatedDnaSequences("sssssssssss"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> record = new HashSet<String>();
        if(s.length()<10){
            return new ArrayList<String>();
        }
        for(int i = 0;i<=s.length()-10;i++){
            String s_c = s.substring(i,i+10);
            if(record.contains(s_c)){
                result.add(s_c);
            }
            else{
                record.add(s_c);
            }
        }
        return new ArrayList<String>(result);
    }
}
