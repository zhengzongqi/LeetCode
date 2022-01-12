package 其他;

import org.junit.Test;

public class T807 {
    @Test
    public void test(){
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3,3},{1,2}}));
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxwidth = new int[grid.length];
        int[] maxheight = new int[grid.length];
        for(int i = 0;i<grid.length;i++){
            int max = 0;
            for(int j = 0 ; j < grid.length ; j++ ){
                max = Math.max(grid[i][j],max);
            }
            maxwidth[i] = max;
        }
        for(int i = 0;i<grid.length;i++){
            int max = 0;
            for(int j = 0 ; j < grid.length ; j++ ){
                max = Math.max(grid[j][i],max);
            }
            maxheight[i] = max;
        }
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ; j < grid.length ; j++ ){
                int bound = Math.min(maxwidth[i],maxheight[j]);
                res += bound - grid[i][j];
            }
        }
        return res;
    }
}
