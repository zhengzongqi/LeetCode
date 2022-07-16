package 数据结构系列.二叉树;

import org.junit.Test;

public class Offer33 {

    @Test
    public void test(){
        System.out.println(verifyPostorder(new int[]{4,3,2,1}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return check(postorder,0,postorder.length-1,null,null);
    }

    private boolean check(int[] postorder,int prev,int last,Integer min,Integer max){
        if(prev>=last){
            return true;
        }
        int root = postorder[last];
        if(min!=null&&root<min){
            return false;
        }
        if(max!=null&&root>max){
            return false;
        }
        int middleidx = 0;
        for(int i = prev;i<=last;i++){
            if(postorder[i]>root){
                middleidx = i-1;
                break;
            }
            if(i==last){
                middleidx = last-1;
            }
        }
        return check(postorder,prev,middleidx,min,root)&&check(postorder,middleidx+1,last-1,root,max);
    }
}
