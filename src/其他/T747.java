package 其他;

import org.junit.Test;

public class T747 {
    @Test
    public void test(){
        System.out.println(dominantIndex(new int[]{6,4,1}));
    }
    public int dominantIndex(int[] nums) {
        int maxidx = 0;   //当前最大元素下标
        boolean check = true;  //最大元素下标为maxidx时，是否能满足两倍的要求
        for(int i =1;i<nums.length;i++){
            if(nums[maxidx]>nums[i]){
                if(check==false||nums[maxidx]<nums[i]*2){check=false;}
                else{check = true;}
            }
            else{
                if(nums[maxidx]*2>nums[i]){check=false;}
                else{check=true;}
                maxidx=i;
            }
        }
        return check==true?maxidx:-1;
    }
}
