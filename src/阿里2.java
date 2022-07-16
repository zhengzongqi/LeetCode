import java.util.*;

public class 阿里2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 1;
        sc.nextLine();
        while(count>0){
            count--;
            sc.nextLong();
            String[] array = sc.nextLine().split(" ");
            long[] nums = new long[5];
            for(int i = 0;i<5;i++){
                nums[i] = Integer.valueOf(array[i]);
            }
            long res = 0;
            Arrays.sort(nums);
            res += nums[1];
            for(int i = 1;i<5;i++){
                nums[i]-=res;
            }
            Arrays.sort(nums);
            res += nums[1];
            System.out.println(res);
        }
    }

}
