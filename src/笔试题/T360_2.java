package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T360_2 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> reslist = new ArrayList<>();
        while(count>0){
            count--;
            int[] num_of_team = new int[4];
            for(int i = 0;i<4;i++){
                num_of_team[i] = sc.nextInt();
            }
            int res = 0;
            res+=num_of_team[3];
            if(num_of_team[0]>=num_of_team[2]){
                num_of_team[0] -= num_of_team[2];
                res+=num_of_team[2];
                num_of_team[2]=0;
            }
            else{
                num_of_team[2]-=num_of_team[0];
                res+=num_of_team[0];
                num_of_team[0] = 0;
        }
            if(num_of_team[0]/2>=num_of_team[1]){
                num_of_team[0] -= num_of_team[1]*2;
                res += num_of_team[1];
                num_of_team[1] = 0;
            }
            else{
                num_of_team[1] -= num_of_team[0]/2;
                res+=num_of_team[0]/2;
                num_of_team[0] = num_of_team[0]%2;
            }
            if(num_of_team[1]>0){res+=num_of_team[1]/2;}
            if(num_of_team[0]>0){res+= num_of_team[0]/4;}
            reslist.add(res);
        }
        for(Integer i : reslist){
            System.out.println(i);
        }
    }
}
