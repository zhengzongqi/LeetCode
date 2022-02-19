package 贪心法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class T1024 {

    @Test
    public void test(){
        int[][] a = new int[][]{ {0,1},{6,8},{0,2},{5,6},{0,4},{1,3},{4,7},{2,5},{2,6},{5,7},{6,9}};
        System.out.println(videoStitching(a,9));
    }
    public int videoStitching(int[][] clips, int time) {
        Deque<int[]> stack = new LinkedList<>();
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                else{
                    return  o2[1]-o1[1];
                }
            }
        });
        if(clips[0][0]!=0){
            return -1;
        }
        int maxtime = clips[0][1];
        if(maxtime>=time){return 1;}
        stack.push(clips[0]);
        for(int i = 1 ;i< clips.length;i++){
            int[] temp = clips[i];
            if(!stack.isEmpty()&&temp[0] == stack.peek()[0]){
                continue;
            }
            if(temp[0]>maxtime){return -1;}
            if(temp[1]>maxtime){

                if(stack.size()>=2){
                    int[] temp1 = stack.poll();
                    int[] temp2 = stack.peek();
                    if(temp2[1]<temp[0]){
                        stack.push(temp1);
                    }
                }

                maxtime = temp[1];
                stack.push(temp);
                if(maxtime>=time){
                    return stack.size();
                }
            }
        }
        if(maxtime<time){return -1;}
        return stack.size();

    }
}
