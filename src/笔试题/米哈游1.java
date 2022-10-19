package 笔试题;
import java.util.*;

public class 米哈游1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0 ;i<n;i++){
            num[i] = sc.nextInt();
        }
        int highc = sc.nextInt();
        int lowc = sc.nextInt();
        if(highc == 0){
            System.out.println("infinity");
        }
        Arrays.sort(num);
        
    }
}
