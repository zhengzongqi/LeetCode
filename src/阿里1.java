import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 阿里1 {
    private static String error1 = "illegal length";
    private static String error2 = "illegal charactor";
    private static String error3 = "acount existed";
    private static String success = "registration complete";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        while(count>0){
            count--;
            String id = sc.nextLine();
            if(set.contains(id)){
                System.out.println(error3);
            }
            else if(id.length()<6||id.length()>12){
                System.out.println(error1);
            }
            else{
                boolean canregi = true;
                for(int i = 0;i<id.length();i++){
                    char c = id.charAt(i);
                    if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z'))){
                        canregi = false;
                        System.out.println(error2);
                        break;
                    }
                }
                if(canregi==true){
                    set.add(id);
                    System.out.println(success);
                }
            }
        }
    }
}
