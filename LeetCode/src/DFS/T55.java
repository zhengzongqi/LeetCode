package DFS;

import org.junit.Test;

public class T55 {
    @Test
    public void test(){
        System.out.println(canJump(new int[]{2,0,0}));
    }
    boolean res = false;
    public boolean canJump(int[] nums) {
        DFS(nums,0);
        return res;
    }

    public void DFS(int[] nums,int pos){
        if(res==true){return;}
        if(pos>=nums.length-1){
            res=true;
            return;
        }
        int maxstep = nums[pos];
        for(int i =1;i<=maxstep;i++){
            if(i>=nums.length){res=true;return;}
            DFS(nums,i+pos);
        }
    }
}
