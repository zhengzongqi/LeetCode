package BFS;

import org.junit.Test;

public class TN {

    @Test
    public void test(){
        System.out.println(isPerfectSquare(808201));
    }
    public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = 46341;
        int mid = (left+right)/2;
        while(left<=right){
            double n = mid*mid;
            if(n == num){
                return true;
            }
            else if(n<num){
                left = mid+1;
                mid = (left+right)/2;
            }
            else{
                right = mid-1;
                mid = (left+right)/2;
            }
        }
        return false;
    }
}
