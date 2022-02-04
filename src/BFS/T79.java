package BFS;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class T79 {

    @Test
    public void test(){
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCESEEE"));
    }


    public boolean exist(char[][] board, String word) {
        contains=false;
        xlen = board.length;
        ylen = board[0].length;
        for(int i = 0;i<board.length;i++){
            for(int j = 0 ; j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    DFS(board,new int[xlen][ylen],word,1,i,j);
                    if(contains==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean contains ;
    int xlen;
    int ylen;

    //一开始想用BFS，结果发现没有好的方法来记录哪些格子已经被走过了，所以用不了
    public void BFS(char[][] board,String word,int xx,int yy ){
        List<int[]> list = new ArrayList<>();
        List<int[]> lastpos = new ArrayList<>();
        int target = word.length();
        int idx = 1;
        list.add(new int[]{xx,yy,-1});
        while(list.size()>0){
            List<int[]> temp = new ArrayList<>();
            if(idx==target){
                contains=true;
                return;
            }
            for(int[] xy : list){
                int x = xy[0];
                int y = xy[1];
                int z = xy[2];
                if(x-1>=0&&board[x-1][y]==word.charAt(idx)&&z!=3){
                    temp.add(new int[]{x-1,y,1});
                }
                if(x+1<xlen&&board[x+1][y]==word.charAt(idx)&&z!=1){
                    temp.add(new int[]{x+1,y,3});
                }
                if(y-1>=0&&board[x][y-1]==word.charAt(idx)&&z!=4){
                    temp.add(new int[]{x,y-1,2});
                }
                if(y+1<ylen&&board[x][y+1]==word.charAt(idx)&&z!=2){
                    temp.add(new int[]{x,y+1,4});
                }
            }
            idx++;
            lastpos = new ArrayList<>(list);
            list = temp;
        }
    }

    public void DFS(char[][] board,int[][] visited,String word,int idx,int x,int y){
        if(idx==word.length()){
            contains=true;
        }
        if(contains==true){
            return;
        }
        visited[x][y] = 1;
        if(x-1>=0&&board[x-1][y]==word.charAt(idx)&&visited[x-1][y]==0){
            DFS(board,visited,word,idx+1,x-1,y);
            visited[x-1][y]=0;
        }
        if(x+1<xlen&&board[x+1][y]==word.charAt(idx)&&visited[x+1][y]==0){
            DFS(board,visited,word,idx+1,x+1,y);
            visited[x+1][y]=0;
        }
        if(y-1>=0&&board[x][y-1]==word.charAt(idx)&&visited[x][y-1]==0){
            DFS(board,visited,word,idx+1,x,y-1);
            visited[x][y-1]=0;
        }
        if(y+1<ylen&&board[x][y+1]==word.charAt(idx)&&visited[x][y+1]==0){
            DFS(board,visited,word,idx+1,x,y+1);
            visited[x][y+1]=0;
        }

    }
}
