package 笔试题;

import java.util.*;

public class JD_ADD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        while(count>0){
            count--;
            Deque<String> stack = new LinkedList<>();
            int line = sc.nextInt();
            sc.nextLine();
            boolean error = false;
            for(int i = 0;i<line;i++){
                String s = sc.nextLine();
                if(error==true){
                    continue;
                }
                //说明是结束语
                if(s.startsWith("end ")){
                    if(stack.isEmpty()||s.length()<=4||!stack.peek().equals(s.substring(4))){

                        error = true;
                    }
                    else{
                        stack.poll();
                    }
                }
                else{
                    stack.push(s);
                }
            }
            if(error == false){
                System.out.println(stack.isEmpty()?"Yes":"No");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
