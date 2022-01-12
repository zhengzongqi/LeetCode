package BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T130 {
    @Test
    public void test(){
        char[][] b = new char[4][4];

        solve(b);
    }

    public void solve(char[][] board) {
        hasreversed = new int[board.length][board[0].length];
        for(int i=1;i<board.length-1;i++){
            for(int j = 1;j<board[0].length-1;j++){
                if(board[i][j]=='O'){
                    hasreversed[i][j]=1;
                    BFS(board,i,j);
                }
            }
        }
    }
    int[][] hasreversed;
    public void BFS(char[][] board,int x,int y){
        List<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{x,y});
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[]{x,y});
        int[][] hasreversed = new int[board.length][board[0].length];
        while(queue.size()!=0){
            Queue<Integer[]> temp = new LinkedList<Integer[]>();
            while(!queue.isEmpty()){
                Integer[] integers = queue.poll();
                if(board[integers[0]-1][integers[1]]=='O'&&hasreversed[integers[0]-1][integers[1]]==0){
                    if(integers[0]-1==0){return;}
                    temp.offer(new Integer[]{integers[0]-1,integers[1]});
                    list.add(new Integer[]{integers[0]-1,integers[1]});
                    hasreversed[integers[0]-1][integers[1]]=1;
                }
                if(board[integers[0]+1][integers[1]]=='O'&&hasreversed[integers[0]+1][integers[1]]==0){
                    if(integers[0]+1==board.length-1){return;}
                    temp.offer(new Integer[]{integers[0]+1,integers[1]});
                    list.add(new Integer[]{integers[0]+1,integers[1]});
                    hasreversed[integers[0]+1][integers[1]]=1;
                }
                if(board[integers[0]][integers[1]-1]=='O'&&hasreversed[integers[0]][integers[1]-1]==0){
                    if(integers[1]-1==0){return;}
                    temp.offer(new Integer[]{integers[0],integers[1]-1});
                    list.add(new Integer[]{integers[0],integers[1]-1});
                    hasreversed[integers[0]][integers[1]-1]=1;
                }
                if(board[integers[0]][integers[1]+1]=='O'&&hasreversed[integers[0]][integers[1]+1]==0){
                    if(integers[1]+1==board[0].length-1){return;}
                    temp.offer(new Integer[]{integers[0],integers[1]+1});
                    list.add(new Integer[]{integers[0],integers[1]+1});
                    hasreversed[integers[0]][integers[1]+1]=1;
                }

            }
            queue = temp;
        }

        for(int i = 0;i<list.size();i++){
            int xx = list.get(i)[0];
            int yy = list.get(i)[1];
            board[xx][yy] = 'X';
        }
    }

}
