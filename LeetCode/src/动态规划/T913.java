package 动态规划;

import org.junit.Test;

import java.util.Arrays;

public class T913 {

    @Test
    public void test(){
        int[][] graph = new int[][]{
                {2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}
        };
        System.out.println(catMouseGame(graph));
    }



    int[][][] dp;
    int[][] graph;
    int n;

    static final int MOUSE_WIN = 1;
    static final int CAT_WIN = 2;
    static final int DRAW = 0;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        dp = new int[n][n][2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1,2,0);
    }

    public int getResult(int mouse,int cat,int turns){
        if(turns==2*n){
            return 0;
        }
        if(dp[mouse][cat][turns]==-1){
            if (mouse == 0) {
                dp[mouse][cat][turns] = 1;
            } else if (cat == mouse) {
                dp[mouse][cat][turns] = 2;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    public void getNextResult(int mouse,int cat,int turns){
        //判断当前谁准备走
        int curMove = turns % 2 == 0 ? mouse : cat;
        //根据当前行动玩家，设定默认结果（默认结果设定为当前行动玩家输），猫鼠胜利失败是反过来的
        int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;
        int[] nextNodes = graph[curMove];
        for (int next : nextNodes) {
            //猫走不到0号格子
            if (curMove == cat && next == 0) {
                continue;
            }
            //下一个状态：鼠走到新格子猫不动，或者猫走到新格子鼠不动
            int nextMouse = curMove == mouse ? next : mouse;
            int nextCat = curMove == cat ? next : cat;
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            if (nextResult != defaultResult) {
                result = nextResult;
                if (result != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}
