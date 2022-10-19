package 查找和排序;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

public class QuickSort {

    @Test
    public void test(){
        int[] a = new int[]{4,5,1,2,3,432,23,1,3,53,5,2,3,4,5,41,1};
        quickSort(a,0,a.length-1);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public void quickSort(int[] nums,int l,int r){
        if(l<r){
            int piv = l;
            int index = l+1;
            for(int i = index;i<=r;i++){
                if(nums[i]<nums[piv]){
                    swap(nums,i,index);
                    index++;
                }
            }
            swap(nums,piv,index-1);
            quickSort(nums,l,index-2);
            quickSort(nums,index,r);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int[] n,int a,int b){
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}
