package 数据结构系列.二叉树;

public class T230 {

    int i = 0;
    int kk = 0;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        kk = k;
        travelse(root);
        return res.val;
    }

    void travelse(TreeNode root){
        if(kk==i||root==null){return;}
        travelse(root.left);
        i++;
        if(i==kk){
            res = root;
            return;
        }
        travelse(root.right);
    }
}
