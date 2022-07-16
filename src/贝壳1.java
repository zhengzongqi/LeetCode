import java.util.*;

public class 贝壳1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Map.Entry<Character,Integer>> entry = map.entrySet();
        int res = 0;
        for(Map.Entry<Character,Integer> e:entry){
            int i = e.getValue();
            res += i/2;
            res -= i%2==0?0:1;
        }
        System.out.println(res);
    }
}
