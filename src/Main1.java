
import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
//           棋盘
            int[][] nums=new int[3][3];
            ArrayList<ArrayList<int[]>> gong=new ArrayList<>();
//            int[][] gong=new int[3][3];
            int count=0;
            for (int j = 0; j < 3; j++) {

                String s= sc.nextLine();
                for (int k = 0; k < 3; k++) {
                    if(s.charAt(k)=='*') {
                        nums[j][k] = 0;
                        count++;
                    }
                    else if(s.charAt(k)=='1')
                        nums[j][k]=1;
                    else if(s.charAt(k)=='2')
                        nums[j][k]=2;
                    else nums[j][k]=3;
                }
            }
            for (int j = 0; j < 3; j++) {
                String s= sc.nextLine();
                String[] split=s.split(" ");
//                gong[Integer.parseInt(split[0])][Integer.parseInt(split[1])]=j;
//                gong[Integer.parseInt(split[2])][Integer.parseInt(split[3])]=j;
//                gong[Integer.parseInt(split[4])][Integer.parseInt(split[5])]=j;
                ArrayList<int[]> temp=new ArrayList<>();
                temp.add(new int[]{Integer.parseInt(split[0]),Integer.parseInt(split[1])});
                temp.add(new int[]{Integer.parseInt(split[2]),Integer.parseInt(split[3])});
                temp.add(new int[]{Integer.parseInt(split[4]),Integer.parseInt(split[5])});
                gong.add(temp);
            }
            int res=backtrack(nums,gong,count,0,0,0);
            Set<int[][]> ans=new HashSet<>();
            if(res>1)
                System.out.println("Multiple");
            else if(res==0)
                System.out.println("No");
            else{
                System.out.println("Unique");
            }
        }
    }
    public static int backtrack(int[][] nums,ArrayList<ArrayList<int[]>> gong,int count,int res,int a,int b){
        if(count==0){
            if (!isTrue(nums,gong)){
                return res;
            }
            res++;
            return res;
        }
        ArrayList<int[]> list=new ArrayList<>();
//        找到0的位置
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(nums[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for (int c=0;c<count;c++){
            int i=list.get(c)[0],j=list.get(c)[1];
                    nums[i][j]=1;
                    res=backtrack(nums,gong,count-1,res,a,b+1);
                    nums[i][j]=2;
                    res=backtrack(nums,gong,count-1,res,a,b+1);
                    nums[i][j]=3;
                    res=backtrack(nums,gong,count-1,res,a,b+1);
//                    nums[i][j]=0;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
        return res;
    }
    public static boolean isTrue(int[][] nums,ArrayList<ArrayList<int[]>> gong){
//        每行不能重复
        for(int j=0;j<3;j++){
            int temp=1;
            for(int i=0;i<3;i++){
                temp=temp*nums[j][i];
            }
            if(temp!=6)
                return false;
        }

//        每列不能重复
        for(int j=0;j<3;j++){
            int temp=1;
            for(int i=0;i<3;i++){
                temp=temp*nums[i][j];
            }
            if(temp!=6)
                return false;
        }
//        每宫不能重复
        for (int i=0;i<3;i++){
            ArrayList<int[]> ints = gong.get(i);
            int temp=1;
            for(int j=0;j<3;j++){
                temp=temp*nums[ints.get(j)[0]][ints.get(j)[1]];
            }
            if(temp!=6)
                return false;
        }
        return true;
    }
}
