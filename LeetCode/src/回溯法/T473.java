package 回溯法;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class T473 {

    @Test
    public void test(){
        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
    public boolean makesquare(int[] matchsticks) {

        Arrays.sort(matchsticks);
        for(int i =0;i<matchsticks.length/2;i++){
            int temp = matchsticks[i];
            matchsticks[i]=matchsticks[matchsticks.length-i-1];
            matchsticks[matchsticks.length-i-1] = temp;
        }

        if(matchsticks.length<4){
            return false;
        }
        matchSticks = matchsticks;
        len =0;
        int[] selected = new int[matchsticks.length];
        for(int i = 0;i<matchsticks.length;i++){
            len+=matchsticks[i];
            selected[i]=1;
        }
        if(len%4!=0){return false;}
        len=len/4;

        backTrack(0,0,0,0,0);

        return res;
    }
    boolean res = false;
    int len;
    int[] matchSticks;

    public void backTrack(int i1,int i2,int i3,int i4,int idx){
        if(res==true){
            return;
        }
        if(i1==i2&&i1==i3&&i1==i4&&i1==len){
            res = true;
        }
        if(idx==matchSticks.length){
            return;
        }
            if(i1+matchSticks[idx]<=len){
                backTrack(i1+matchSticks[idx],i2,i3,i4,idx+1);
                //i1-=matchSticks[idx];
            }
            if(i2+matchSticks[idx]<=len){
                backTrack(i1,i2+matchSticks[idx],i3,i4,idx+1);
                //i2-=matchSticks[idx];
            }
            if(i3+matchSticks[idx]<=len){
                backTrack(i1,i2,i3+matchSticks[idx],i4,idx+1);
                //i3-=matchSticks[idx];
            }
            if(i4+matchSticks[idx]<=len){
                backTrack(i1,i2,i3,i4+matchSticks[idx],idx+1);
                //i4-=matchSticks[idx];
            }
    }

//    public void backTrack(int[] selected,List<Integer> prepareSelect,int count,int sum){
//        if(res==true){
//            return;
//        }
//        if(count==4){
//            boolean r = true;
//            for(int i=0;i<selected.length;i++){
//                if(selected[i]==1){
//                    r=false;
//                    break;
//                }
//                if(r==true){
//                    res=true;
//                }
//            }
//        }
//
//        for(int i = 0;i<selected.length;i++){
//            if(selected[i]==1){
//                //可以加
//                if(matchSticks[i]+sum>len){
//                    continue;
//                }
//                else if(matchSticks[i]+sum<len){
//                    prepareSelect.add(i);
//                    selected[i]=0;
//                    backTrack(selected,prepareSelect,count,sum+matchSticks[i]);
//                    selected[i]=1;
//                    prepareSelect.remove((Integer)i);
//                }
//                else if(matchSticks[i]+sum==len){
//                    prepareSelect.add(i);
//                    selected[i]=0;
//                    backTrack(selected,prepareSelect,count+1,0);
//                    selected[i]=1;
//                    prepareSelect.remove((Integer)i);
//                }
//            }
//        }
//    }
}
