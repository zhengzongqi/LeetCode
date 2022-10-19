import java.util.*;

public class 网易1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int mon1 = sc.nextInt();
        int mon2 = sc.nextInt();
        int skill1 = sc.nextInt();
        int skill2 = sc.nextInt();

        int[][] dp = new int[mon1+1][mon2+1];
        for(int i = 1;i<=mon1;i++){
            dp[i][0] = Math.min(dp[i-skill1<0?0:i-skill1][0],dp[i-skill2<0?0:i-skill2][0])+1;
        }
        for(int i = 1;i<=mon2;i++){
            dp[0][i] = Math.min(dp[0][i-skill1<0?0:i-skill1],dp[0][i-skill2<0?0:i-skill2])+1;
        }
        for(int i = 1;i<=mon1;i++){
            for(int j = 1;j<=mon2;j++){
                int xa = i-skill1<0?0:i-skill1;
                int ya = i-skill2<0?0:i-skill2;
                int xb = j-skill1<0?0:j-skill1;
                int yb = j-skill2<0?0:j-skill2;
                dp[i][j] = Math.min(Math.min(dp[xa][j],dp[i][xb]),dp[ya][yb])+1;
            }
        }
        System.out.println(dp[mon1][mon2]);

    }

}
