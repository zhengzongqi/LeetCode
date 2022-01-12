package 数据结构系列.二叉树;

public class T110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){return true;}
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){return false;}
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int maxDepth(TreeNode root) {
        if(root==null){return 0;}
        if(root.left==null&&root.right==null){return 1;}
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
