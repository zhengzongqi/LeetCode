package 贪心法;

public class T55 {
    boolean res = false;
    public boolean canJump(int[] nums) {
        int maxpos = 0;
        for(int i = 0;i<nums.length;i++){
            if(i>maxpos){
                return false;
            }
            int step = nums[i];
            maxpos = Math.max(step+i,maxpos);
        }
        return true;
    }
}
