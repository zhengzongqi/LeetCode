package 笔试题;

import java.util.*;


public class 美团2 {
    //寻找数字
    public static void main(String[] args){

        Scanner read = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        while(read.hasNextLine()){
            res.clear();
            String s = read.nextLine();
            int prev = 0;
            for(int i = 0;i<s.length();i++){
                if(isNum(s.charAt(i))){
                    prev = i;
                    while(i<s.length()&&isNum(s.charAt(i))){
                        i++;
                    }
                    res.add(Integer.valueOf(s.substring(prev,i)));
                }
            }
            Collections.sort(res);
            for(Integer i : res){
                System.out.println(i);
            }
        }
    }

    public static boolean isNum(char c){
        return  (c>='0'&&c<='9')?true:false;
    }

}
