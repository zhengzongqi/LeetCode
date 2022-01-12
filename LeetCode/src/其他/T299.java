package 其他;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T299 {
    @Test
    public void test(){
        System.out.println(getHint("1122","2211"));
    }

    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        List<Character> remains = new ArrayList<Character>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0 ; i <secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
                remains.add(guess.charAt(i));
            }
        }

        for(Character c : remains){
            if(map.getOrDefault(c,0)!=0){
                map.put(c,map.get(c)-1);
                cows++;
            }
        }

        return String.valueOf(bulls)+"A"+String.valueOf(cows)+"B";
    }
}
