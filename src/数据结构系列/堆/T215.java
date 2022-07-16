package 数据结构系列.堆;

import org.junit.Test;

public class T215 {

    @Test
    public void test(){
        System.out.println(findKthLargest(new int[]{1,2,3,4,5,6},1));
    }

    //使用数组来存储堆结构
    //下标为a的元素，其左右子树为2*a+1,2*a+2;
    //先把整个数组看成一个二叉堆，然后进行调整；
    //随后从堆中取k-1次，取一次调整一次，最后返回堆顶元素

    public int findKthLargest(int[] nums, int k)
    {
        int n = nums.length;
        build_maxHeap(nums);
        for (int i = 0; i < k - 1; i ++)
        {
            swap(nums,0,n-1-i);
            adjust(nums, 0, n-1-i );
        }
        return nums[0];
    }
    //初始化大根堆
    public void build_maxHeap(int [] nums)
    {
        int n = nums.length;
        for (int root = n/2-1; root > -1; root --)
        {
            adjust(nums, root, n );
        }
    }
    //调整以root为根的子树，将其转化为大根堆
    public void adjust(int[] nums,int root,int heapsize){
        if(root>=heapsize){
            return;
        }
        if(root*2+1<heapsize&&nums[root*2+1]>nums[root]){
            swap(nums,root*2+1,root);
            adjust(nums,root*2+1,heapsize);
        }
        if(root*2+2<heapsize&&nums[root*2+2]>nums[root]){
            swap(nums,root*2+2,root);
            adjust(nums,root*2+2,heapsize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
