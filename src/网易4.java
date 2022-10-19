import java.util.*;
public class 网易4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        X = x;
        Y = y;
        int[][] zhaoze = new int[x][y];
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                zhaoze[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[X][Y];
        for(int i = 1;i<X;i++){
            dp[i][0] = zhaoze[i][0] == zhaoze[i-1][0]?dp[i-1][0] + 1:dp[i-1][0] + 2;
        }
        for(int i = 1;i<Y;i++){
            dp[0][i] = zhaoze[0][i] == zhaoze[0][i-1]?dp[0][i-1]+1:dp[0][i-1]+2;
        }
        for(int i = 1;i<X;i++){
            for(int j = 1;j<Y;j++){
                int up = zhaoze[i][j] == zhaoze[i-1][j]?1:2;
                int left = zhaoze[i][j] == zhaoze[i][j-1]?1:2;
                dp[i][j] = Math.min(dp[i-1][j]+up,dp[i][j-1]+left);
            }
        }
        System.out.println(dp[X-1][Y-1]);
    }
    static int res = Integer.MAX_VALUE;
    static int X;
    static int Y;
    //绝不会往回走，只能往右或往下   prev=1代表之前是沼泽,0代表之前是平地
    public static void DFS(int x,int y,int cost,int[][] zhaoze,int prev){
        if(x==X-1&&y==Y-1){
            res= Math.min(cost,res);
            return;
        }
        //往下
        if(x<X-1) {
            if(zhaoze[x+1][y]==0){
                int c = prev==0?1:2;
                DFS(x+1,y,cost+c,zhaoze,0);
            }
            if(zhaoze[x+1][y]==1){
                int c = prev==1?1:2;
                DFS(x+1,y,cost+c,zhaoze,1);
            }
        }
        if(y<Y-1){
            if(zhaoze[x][y+1]==0){
                int c = prev==0?1:2;
                DFS(x,y+1,cost+c,zhaoze,0);
            }
            if(zhaoze[x][y+1]==1){
                int c = prev==1?1:2;
                DFS(x,y+1,cost+c,zhaoze,1);
            }
        }
    }

}
