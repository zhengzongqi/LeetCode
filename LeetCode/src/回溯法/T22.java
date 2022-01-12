package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class T22 {

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        len = 2*n;
        backTrack(n,n,0,"",0);
        return res;
    }

    List<String> res;
    int len;
    public void backTrack(int left,int right,int idx,String now,int balance){
        if(now.length()==len&&left==0&&right==0){
            res.add(now);
            return;
        }
        if(left!=0){
            backTrack(left-1,right,idx+1,now+"(",balance+1);
        }
        if(right!=0&&balance>0){
            backTrack(left,right-1,idx+1,now+")",balance-1);
        }
    }
}
