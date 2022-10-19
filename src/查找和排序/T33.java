package 查找和排序;

import org.junit.Test;

public class T33 {
    static int ss = 0;
    @Test
    public void test(){
        //search(new int[]{1,3},0);
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int reverseidx = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(l==r){
                break;
            }
            if(nums[l]<=nums[mid]){
                if(target>=nums[l]&&target<=nums[mid]){
                    r=mid;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[mid+1]<=nums[r]){
                if(target>=nums[mid+1]&&target<=nums[r]){
                    l = mid+1;
                }
                else{
                    r=mid;
                }
            }

        }
        return -1;
    }
}
