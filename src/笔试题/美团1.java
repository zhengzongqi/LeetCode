package 笔试题;

import java.util.*;

public class 美团1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[] mark_scan = new int[n];
        int[] mark_add = new int[n];
        int caozuocishu = 0;
        int res = 0;
        while (caozuocishu < m) {
            caozuocishu++;
            if (sc.nextInt() == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                for (int i = l - 1; i <= r - 1; i++) {
                    mark_scan[i]++;
                    res += mark_add[i];
                }
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int add = sc.nextInt();
                for (int i = l - 1; i <= r - 1; i++) {
                    mark_add[i] += add;
                }
            }
        }
        int idx = nums.length - 1;
        Arrays.sort(mark_scan);
        while (idx>=0&&mark_scan[idx] != 0) {
            res += mark_scan[idx] * nums[idx];
            idx--;
        }

        System.out.println(res);


    }
}