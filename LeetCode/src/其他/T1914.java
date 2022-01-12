package 其他;

import org.junit.Test;

public class T1914 {

    @Test
    public void test(){
        rotateGrid(new int[][]{{1,2},{3,4}},1);
    }


    public int[][] rotateGrid(int[][] grid, int k) {
        int height = grid.length;
        int width = grid[0].length;
        int rowcount = Math.min(height,width)/2;
        for(int i = 0 ; i<rowcount;i++){
            int numofsquare = 2*(width+height-4*i)-4;
            int remove_count = k%numofsquare;
            //x方向下标为 i -- width - i - 1
            //y方向下标为 i -- height - i - 1
            for(int time = 1 ; time<=remove_count ; time++){

                int remain = grid[i][i];
                for(int x1 = i;x1 < width-i-1;x1++ ){
                    grid[i][x1] = grid[i][x1+1];
                }
                for(int x1 = i;x1 < height-i-1;x1++ ){
                    grid[x1][width-i-1] = grid[x1+1][width-i-1];
                }
                for(int x1 = width-i-1;x1 > i;x1-- ){
                    grid[height-i-1][x1] = grid[height-i-1][x1-1];
                }
                for(int x1 = height-i-1;x1 > i;x1-- ){
                    grid[x1][i] = grid[x1-1][i];
                }
                grid[i+1][i] = remain;
            }
        }
        return grid;
    }
}
