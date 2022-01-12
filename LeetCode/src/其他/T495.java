package 其他;

import org.junit.Test;

public class T495 {
    @Test
    public void test(){
        System.out.println(findPoisonedDuration(new int[]{1,4,5,7},2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        if(timeSeries.length==0){
            return 0;
        }
        int time_st = timeSeries[0];
        int time_ed = time_st+duration-1;
        for(int i = 1 ;i< timeSeries.length ;i++){
            if(timeSeries[i]<=time_ed){
                time_ed = timeSeries[i]+duration-1;
                if(i==timeSeries.length-1){
                    res += time_ed - time_st+1;
                }
            }
            else{
                res += time_ed - time_st+1;
                time_st = timeSeries[i];
                time_ed = time_st+duration-1;
                if(i==timeSeries.length-1){
                    res += duration;
                }
            }
        }

        return res;
    }
}
