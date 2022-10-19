package 查找和排序;

import org.junit.Test;

public class T34 {
    @Test
    public void test(){
        searchRange1(new int[]{1,4},4);
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
        }
        int l = 0,r = nums.length-1,resl = -1,resr = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                //找边界
                resl = mid;
                resr = mid;
                while(resl>0&&nums[resl]==nums[resl-1]){resl--;}
                while(resr<nums.length-1&&nums[resr]==nums[resr+1]){resr++;}
                return new int[]{resl,resr};
            }
            else if(nums[mid]>target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] searchRange1(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
        }
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int l = 0,r = nums.length-1,resl = -1,resr = -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                l = mid;
                break;
            }
            else if(nums[mid]>target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        if(target!=nums[l])
            return new int[]{-1,-1};
        resl = l;
        resr = l;
        while(resl>0&&nums[resl]==nums[resl-1]){resl--;}
        while(resr<nums.length-1&&nums[resr]==nums[resr+1]){resr++;}
        return new int[]{resl,resr};
    }
}
