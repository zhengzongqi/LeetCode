package 数据结构系列.堆;

import org.junit.Test;

import java.util.Arrays;

public class Offer40 {
    @Test
    public void test(){
        System.out.println(getLeastNumbers(new int[]{3,4,2,1,3,5,6,7,8},4));
    }

    int[] heap;
    int mark = -1;
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        heap = new int[arr.length];
        Arrays.fill(heap,Integer.MAX_VALUE);
        for(int i = 0;i<arr.length;i++){
            addHeap(arr[i]);
        }
        for(int i = 0;i<k;i++){
            res[i] = getTop();
        }
        return res;
    }

    private void addHeap(int k){
        mark++;
        heap[mark] = k;
        adjust();
    }

    private int getTop(){
        int top = heap[0];
        replace(0,mark);
        mark--;
        adjust();
        return top;
    }

    private void adjust(){
        for(int i = mark/2;i>=0;i--){
            if((2*i+1)<=mark&&heap[i]>heap[2*i+1]){
                replace(i,2*i+1);
            }
            if((2*i+2)<=mark&&heap[i]>heap[2*i+2]){
                replace(i,2*i+2);
            }
        }
    }
    private void replace(int a,int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
