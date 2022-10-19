import java.util.Scanner;

public class 百度1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = 0;
        int y = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='L'){
                x--;
            }
            else  if(c=='R'){
                x++;
            }
            else  if(c=='U'){
                y++;
            }
            else  if(c=='D'){
                y--;
            }
        }
        System.out.println("("+x+","+y+")");
    }
}
