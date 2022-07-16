import java.util.*;
public class 网易2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int[][] dp = new int[len+1][2];
        for(int i=2;i<=len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-2][0],dp[i-2][1])+score(s.charAt(i-1),s.charAt(i-2));
        }
        System.out.println(Math.max(dp[len][0],dp[len][1]));
    }

    public static int score(char a,char b){
        if(a==b){
            return 2*(a-'a'+1);
        }
        if(a==b+1||a==b-1){
            return (a-'a'+1)+(b-'a'+1);
        }
        else {
            return 0;
        }
    }
}
