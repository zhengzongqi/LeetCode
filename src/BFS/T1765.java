package BFS;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T1765 {

    @Test
    public void test(){
        int[][] res = highestPeak(new int[][]{{0,1},{0,0}});
        for(int i = 0 ;i<2;i++){
            for(int j = 0;j<2;j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    int[][] height ;
    int m;
    int n;
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n=isWater[0].length;
        height = new int[m][n];
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i =0;i<m;i++){
            Arrays.fill(height[i],-1);
        }
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(isWater[i][j]==1){
                    queue.offer(new Integer[]{i,j});
                    height[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            Queue<Integer[]> temp_queue = new LinkedList<>();
            while(!queue.isEmpty()){
                Integer[] temp_integer = queue.poll();
                int i = temp_integer[0],j=temp_integer[1];
                if(i-1>=0&&height[i-1][j]==-1){
                    height[i-1][j] = getMaxheight(i-1,j);
                    temp_queue.offer(new Integer[]{i-1,j});
                }
                if(i+1<m&&height[i+1][j]==-1){
                    height[i+1][j] = getMaxheight(i+1,j);
                    temp_queue.offer(new Integer[]{i+1,j});
                }
                if(j-1>=0&&height[i][j-1]==-1){
                    height[i][j-1] = getMaxheight(i,j-1);
                    temp_queue.offer(new Integer[]{i,j-1});
                }
                if(j+1<n&&height[i][j+1]==-1){
                    height[i][j+1] = getMaxheight(i,j+1);
                    temp_queue.offer(new Integer[]{i,j+1});
                }
            }
            queue = temp_queue;
        }
        return height;
    }

    public int getMaxheight(int i,int j){
        int maxheight = Integer.MAX_VALUE;
        if(i-1>=0&&height[i-1][j]!=-1){
            maxheight = Math.min(maxheight,height[i-1][j]);
        }
        if(i+1<m&&height[i+1][j]!=-1){
            maxheight = Math.min(maxheight,height[i+1][j]);
        }
        if(j-1>=0&&height[i][j-1]!=-1){
            maxheight = Math.min(maxheight,height[i][j-1]);
        }
        if(j+1<n&&height[i][j+1]!=-1){
            maxheight = Math.min(maxheight,height[i][j+1]);
        }
        return maxheight+1;
    }
}
