package 贪心法;

import org.junit.Test;

import java.util.Arrays;

public class t846 {
    @Test
    public void test(){
        System.out.println(isNStraightHand(new int[]{1,2,3,7,8,37},3));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        int size = hand.length/groupSize;
        int[][] group = new int[size][2];
        for(int i =0;i<size;i++){
            group[i][0]=-1;
            group[i][1]= 0;
        }
        for(int i = 0;i<hand.length;i++){
            boolean can_continue = false;
            for(int j=0;j<size;j++){
                if((group[j][0]==hand[i]-1||group[j][0]==-1)&&group[j][1]<groupSize){
                    can_continue = true;
                    group[j][0]=hand[i];
                    group[j][1]+=1;
                    break;
                }
            }
            if(can_continue==false){return false;}
        }
        for(int i = 0;i<size;i++){
            if(group[i][1]!=groupSize){
                return false;
            }
        }
        return true;
    }
}
