package 查找和排序;

public class T35 {

    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1]<target){
            return nums.length;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }
            else if(nums[mid] >target){
                r=mid;
            }
            else{
                return mid;
            }
        }
        return l;
    }
    //如果mid位置数大于target，说明要去左边找，但是mid这个位置有可能会是答案（要插入的位置）
    //如果mid位置数小于target，说明要去右边找，而且mid这个位置不可能是答案，target就算只比nums[mid]大一点点也会在mid+1的位置插入
}
