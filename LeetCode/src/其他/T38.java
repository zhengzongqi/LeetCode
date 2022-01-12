package 其他;

import org.junit.Test;

public class T38 {

    @Test
    public void test(){
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        StringBuilder now = new StringBuilder("1");
        if(n==1){
            return "1";
        }

        for (int i = 2;i<=n;i++){
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for(int j = 0;j<now.length();j++){
                if(j==now.length()-1){
                    temp = temp.append(String.valueOf(count)).append(now.charAt(j));
                    count=1;
                }
                else{
                    if (now.charAt(j)!=now.charAt(j+1)){
                        temp = temp.append(String.valueOf(count)).append(now.charAt(j));
                        count=1;
                    }
                    else{
                        count++;
                    }
                }
            }
            now = temp;
        }
        return now.toString();
    }
}
