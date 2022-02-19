package DFS;

public class T1219 {
    int res = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ; j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    DFS(i,j,grid,new int[grid.length][grid[0].length],grid[i][j]);
                }
            }
        }
        return res;
    }

    private void DFS(int x,int y,int[][] grid,int[][] reversed,int gold){
        reversed[x][y]=1;
        res = Math.max(gold,res);
        if(x>0&&reversed[x-1][y]==0&&grid[x-1][y]!=0){
            //reversed[x-1][y] = 1;
            DFS(x-1,y,grid,reversed,gold+grid[x-1][y]);
        }
        if(y>0&&reversed[x][y-1]==0&&grid[x][y-1]!=0){
            //reversed[x][y-1] = 1;
            DFS(x,y-1,grid,reversed,gold+grid[x][y-1]);
        }
        if(x<grid.length-1&&reversed[x+1][y]==0&&grid[x+1][y]!=0){
            //reversed[x+1][y] = 1;
            DFS(x+1,y,grid,reversed,gold+grid[x+1][y]);
        }
        if(y<grid[0].length-1&&reversed[x][y+1]==0&&grid[x][y+1]!=0){
            //reversed[x][y+1] = 1;
            DFS(x,y+1,grid,reversed,gold+grid[x][y+1]);
        }
        reversed[x][y]=0;
    }
}
