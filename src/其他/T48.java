package 其他;

import org.junit.Test;

public class T48 {
    @Test
    public void test(){
        rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0;i<len/2;i++){
            for(int j = 0;j<len-2*i;j++){
                swap(matrix,i,i+j,i+j,len-i-1);
                swap(matrix,i,i+j,len-i-1,len-i-j-1);
                swap(matrix,i,i+j,len-i-1-j,i);
            }
        }
    }

    public void swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
