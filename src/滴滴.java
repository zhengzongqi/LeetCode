import java.util.*;

public class 滴滴 {
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
        while(count>0){
            count--;
            String[] replace = sc.nextLine().split(" ");
            while(s.contains(replace[0])){
                s=s.replaceFirst(replace[0],replace[1]);
            }
        }
        System.out.println(s);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        while(count>0){
            count--;
            int len = sc.nextInt();
            int[] nums = new int[len];
            for(int i = 0;i<len;i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(brackTrack(nums,0,-1,Integer.MAX_VALUE)?"Yes":"No");
        }
    }

    public static boolean brackTrack(int[] nums,int idx,int up,int low){
        if(idx==nums.length){
            return true;
        }
        boolean resred = false;
        boolean resblue = false;
        if(nums[idx]>up){
            resred = brackTrack(nums,idx+1,nums[idx],low);
            if(resred==true){return true;}
        }
        if(nums[idx]<low){
            resblue = brackTrack(nums,idx+1,up,nums[idx]);
            if(resblue==true){return true;}
        }
        return false;
    }
}
