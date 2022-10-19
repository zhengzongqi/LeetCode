
import java.util.*;
public class Meituan {
    static int n ;
    static  int m;
    static  int k;
    static int[][] price;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        price = new int[m][3];
        for(int i = 0 ; i <3;i++){
            for(int j = 0;j<m;j++){
                price[j][i] = sc.nextInt();
            }
        }
        backTrack(k,0,0);
        System.out.println(res);
    }

    static int res = 0;

    public static void backTrack(int posnow,int day,int totalprice){
        if(day==m){
            res = Math.max(res,totalprice);
            return;
        }
        if(price[day][0]==posnow){
            backTrack(posnow,day+1,totalprice+price[day][1]);
        }
        else{
            //去
            backTrack(price[day][0],day+1,totalprice+price[day][2]);
            //不去
            backTrack(posnow,day+1,totalprice);
        }
    }
}
