package 动态规划;

public class Offer47 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int add = 0;
        for(int i = 0;i<grid.length;i++){
            add +=grid[i][0];
            dp[i][0] = add;
        }
        add = 0;
        for(int i = 0;i<grid[0].length;i++){
            add+=grid[0][i];
            dp[0][i] = add;
        }

        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
