package 贪心法;

import org.junit.Test;

import java.util.Arrays;

public class T452 {

    @Test
    public void test(){
        int[][] as = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        //quick_sort(as,0,as.length-1);
        for(int i = 0 ;i <as.length;i++){
            //System.out.println(as[i][0]+" "+as[i][1]+"\n");
        }
        System.out.println(findMinArrowShots(as));
    }

    public int findMinArrowShots(int[][] points) {
        quick_sort(points,0,points.length-1);
        int res = 0;
        int[] ballon = new int[2];
        int lidx = 0;
        int ridx = 0;
        for(int i = 0 ;i<points.length;i++){
            ballon = points[i];
            lidx = ballon[0];
            ridx = ballon[1];
            boolean cantogether = true;
            while(cantogether==true){
                if(i==points.length-1){break;}
                int[] nextballon = points[i+1];
                //当前气球集合跟下一个气球没有交集
                if(nextballon[0]>ridx){
                    break;
                }
                //如果有交集，则nextballon可以加入当前气球集合，用同一只箭戳破，箭能选择的范围为[lidx,ridx]
                else{
                    lidx = Math.max(lidx,nextballon[0]);
                    ridx = Math.min(ridx,nextballon[1]);
                    i++;
                }

            }
            res++;
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
            while(i<j && a[j][0]>=temp[0]){
                j--;
            }
            //往右移位，直到小于temp
            while(i<j && a[i][0]<=temp[0]){
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
