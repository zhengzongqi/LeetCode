package 数据结构系列.二叉树;

public class T101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return (check(t1.left,t2.right)&&check(t1.right,t2.left));
    }
}
