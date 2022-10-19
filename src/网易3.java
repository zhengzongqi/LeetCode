import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Scanner;

public class 网易3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        N=n;
        res = new int[n]; //2代表偶数，1代表基数
        int jicount = n/2;
        int oucount = n/2;
        if(n%2==1){
            jicount++;
        }
        backTrack(0,jicount,oucount,new int[n]);

        int markji = 1;
        int markou = 2;
        for(int i = 0;i<n;i++){
            if(res[i] == 1){
                System.out.print(markji);
                markji+=2;
            }
            if(res[i] == 2){
                System.out.print(markou);
                markou+=2;
            }
            if(i!=n-1){
                System.out.print(" ");
            }
        }

    }
    static int N;
    static int[] res;
    static boolean hasans = false;
    static void backTrack(int idx,int jicount,int oucount,int[] temp){
        if(hasans==true){return;}
        if(idx==N){
            res = temp;
            hasans = true;
            return;
        }
        //父节点是奇数,只能填偶数
        if(idx==0||temp[(idx-1)/2]%2==1) {
            temp[idx] = 2;
            backTrack(idx + 1, jicount, oucount-1, temp);
        }
        //父节点是偶数,可以填奇数或者偶数
        if(idx==0||temp[(idx-1)/2]%2==0){
            //填偶数
            if(oucount>0){
                temp[idx] = 2;
                backTrack(idx + 1, jicount, oucount-1, temp);
            }
            if(hasans==true){return;}
            //填奇数
            if(jicount>0){
                temp[idx] = 1;
                backTrack(idx + 1, jicount-1, oucount, temp);
            }
        }
    }
}
