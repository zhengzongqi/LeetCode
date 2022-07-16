package 其他;

import org.junit.Test;

public class T14 {
    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new String[]{"ab","ab"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        String s = "";
        int idx = 0;
        while(true){
            if(strs[0].length()==0){
                return "";
            }
            if(idx>=strs[0].length()){return s;}
            char c = strs[0].charAt(idx);
            for(int i = 1;i<strs.length;i++){
                if(strs[i].length()>idx&&strs[i].charAt(idx)==c){
                }
                else{
                    return s;
                }
            }
            s+=c;
            idx++;
        }
    }
}
