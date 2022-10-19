package 笔试题;

import org.junit.Test;

public class PDD面试 {

    @Test
    public void test(){
        int[] s = new int[]{1,1,3,4,5,1,2,2,3,4,4,1};
        System.out.println(question(s));
        for(int i = 0;i<s.length;i++){
            System.out.print(s[i]+" ");
        }
    }
    public int question(int[] nums){
        if(nums.length<=2){
            return nums.length;
        }
        int slow = 1;
        int fast = 1;
        while(fast!=nums.length){
            if(nums[fast] == nums[fast-1]){
                fast++;
            }
            else if(nums[fast] > nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow+1;
    }
}
