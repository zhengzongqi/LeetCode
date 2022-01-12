package 其他;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T825 {
    @Test
    public void test(){
        System.out.println(numFriendRequests(new int[]{20,20,8,8}));
    }


    public int numFriendRequests(int[] ages) {
        Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
        Arrays.sort(ages);
        double[][] age = new double[120][2];
        int len = 0;
        for(int i=0;i<ages.length;i++){
            dict.put(ages[i],dict.getOrDefault(ages[i],0)+1);
            if (dict.get(ages[i])==1){
                age[len][0] = ages[i];
                len++;
            }
        }
        int res= 0;

        for(int i = 0 ; i<len;i++){
            for(int j = 0;j<len;j++){
                if(i==j){
                    if(age[i][0]>14){
                        res+=dict.get((int)age[i][0])*(dict.get((int)age[i][0])-1);
                    }
                }
                else{
                    if((age[j][0]>0.5*age[i][0]+7)&&(age[j][0]<=age[i][0])){
                        if(!(age[j][0]>100&&age[i][0]<100)){
                            age[i][1]++;
                            res +=dict.get((int)age[i][0])*dict.get((int)age[j][0]);
                        }
                    }
                }
            }
        }
        return res;
    }
}
