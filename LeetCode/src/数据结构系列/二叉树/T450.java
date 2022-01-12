package 数据结构系列.二叉树;

import org.junit.Test;

public class T450 {

    @Test
    public void test(){
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(7);
        deleteNode(t,3);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val ==key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right,minNode.val);
        }
        else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
