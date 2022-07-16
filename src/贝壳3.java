import java.util.*;
public class 贝壳3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        char[][] matrix = new char[len][len];
        int res = 0;
        for(int i = 0;i<len;i++){
            String stemp = sc.nextLine();
            for(int j = 0;j<len;j++){
                matrix[i][j] = stemp.charAt(j);
            }
            if(stemp.contains(s)){
                res++;
            }
        }
        for(int i = 0;i<len;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<len;j++){
                sb.append(matrix[j][i]);
            }
            if(sb.toString().contains(s)){
                res++;
            }
        }
        System.out.println(res);
    }
}
