package 贪心法;

import org.junit.Test;

import java.util.Arrays;

public class T1996 {

    @Test
    public void test(){
        System.out.println(numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3},{2,3}}));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        quick_sort(properties,0,properties.length-1);
        int res = 0;
        //之前层级攻击力角色中，防御力的最大值
        int maxdef = 0;
        int firstattack = properties[0][0];
        for(int i = 0;i<properties.length;i++){
            int attacknow = properties[i][0];
            if(attacknow == firstattack){
                maxdef = Math.max(maxdef,properties[i][1]);
                continue;
            }
            //当前层级攻击力的角色中，防御力最大值
            int maxdef_inattacknow = 0;
            while(i<=properties.length-1){
                if(properties[i][0]!=attacknow){
                    i--;
                    break;
                }
                if(properties[i][1]<maxdef){
                    res++;
                }
                maxdef_inattacknow = Math.max(maxdef_inattacknow,properties[i][1]);
                i++;
            }
            maxdef = Math.max(maxdef,maxdef_inattacknow);
        }
        return res;
    }


    public void quick_sort(int[][] a,int left,int right){
        //结束迭代
        if(left > right){
            return;
        }
        int i = left ;
        int j = right;
        int[] temp = a[left];//设置基准值，将最左端元素作为基准值
        while(i != j){
            //往左移位，直到大于temp
            while(i<j && a[j][0]<=temp[0]){
                j--;
            }
            //往右移位，直到小于temp
            while(i<j && a[i][0]>=temp[0]){
                i++;
            }
            if(i < j){
                //交换彼此的数据
                int[] temp1 = Arrays.copyOf(a[i],2);
                a[i] = a[j];
                a[j] = temp1;
            }
        }
        //交换基位数据
        int[] kk = a[i];
        a[i] = temp;
        a[left] = kk;
        //下一次迭代
        quick_sort(a,left,i-1);//左半边
        quick_sort(a,j+1,right);//右半边
    }
}
