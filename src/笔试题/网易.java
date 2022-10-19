package 笔试题;

import java.util.Scanner;

public class 网易 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            T--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[][] num = new String[n][n];
            for(int i = 0;i<n;i++){
                num[i] = sc.nextLine().split(" ");
            }
            while(m-->0){
                int x = sc.nextInt();
                int y = sc.nextInt();

            }
        }
    }
}
