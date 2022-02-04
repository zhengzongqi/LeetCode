package 数据结构系列.二叉树;

public class T897 {
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode t = new TreeNode();
        res = t;
        reverse(root);
        return t.right;
    }
    TreeNode res;

    public void reverse(TreeNode t){
        if(t==null){
            return;
        }
        reverse(t.left);

        TreeNode tt = new TreeNode(t.val);
        res.right = tt;
        res = tt;

        reverse(t.right);
    }
}
