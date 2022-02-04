package 回溯法;

import org.junit.Test;

public class T746 {
    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] c = new int[cost.length+2];
        int i = 0;
        for(i=0;i<cost.length;i++){
            c[i]=cost[i];
        }
        backTrace(c,-1,0);
        return result;
    }

    int result = Integer.MAX_VALUE;

    public void backTrace(int[] cost,int step,int power){
        if(step>=cost.length-2){
            result =Math.min(result,power);
        }
        else{
            //先走一步
            step+=1;
            power += cost[step];
            backTrace(cost,step,power);
            //在尝试走两步
            power -= cost[step];
            step+=1;
            power += cost[step];
            backTrace(cost,step,power);
        }
    }
}
