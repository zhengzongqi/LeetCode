package 贪心法;

import org.junit.Test;

public class T330 {

    @Test
    public void test(){
        minPatches(new int[]{1,3},6);
    }



    public int minPatches(int[] nums, int n) {

        long x = 0 ; //当前nums中能够表示的区间上限
        int res = 0;  //要添加的数字个数
        int j = 0;
        while(x<n){
            //num[0]-nums[j-1]已经可以表示1-x，那么如果nums[j]<=x+1时，num[0]-nums[j]就可以表示1-x+nums[j];
            if(nums[j]<=x+1&&j<nums.length){
                x = x + nums[j];
                j++;
            }
            //倘若nums[j]>x+1,num[0]-nums[j]将无法表示1-x+nums[j];中间会有空隙，例如x+1这个数就无法通过组合得到
            //于是我们需要向nums[]中添加值为x+1的数，这时候可以根据新加的数再次拓展区间
            //如果新加了一个数后，区间还是没法到达nums[j]，就需要继续加，继续拓展区间
            else{
                //nums中需要加上一位值为x+1的数
                res++;
                //加上之后再次拓宽区间范围
                x=2*x+1;
            }
        }
        return res;
    }

}
