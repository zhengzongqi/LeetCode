package 数据结构系列.二叉树;

public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null&&B==null){
            return true;
        }
        if(A==null||B==null){
            return false;
        }
        return contains(A,B);

    }

    public boolean contains(TreeNode A, TreeNode B){
        if(A==null){
            return false;
        }
        boolean b = false;
        if(A.val==B.val){
            b = check(A,B);
        }
        return b==true?b:contains(A.left,B)||contains(A.right,B);
    }

    private boolean check(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return check(A.left,B.left)&&check(A.right,B.right);
    }
}
