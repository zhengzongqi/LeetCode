package DFS;

import org.junit.Test;

public class T112 {
    @Test
    public void test(){
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        t.left=t1;
        System.out.println(hasPathSum(t,2));
    }
    boolean alreadyFind = false;
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){return false;}
        target = targetSum;
        DFS(root,root.val);
        return alreadyFind;
    }
    public void DFS(TreeNode t,int sum){
        if(alreadyFind==true||t==null){return;}
        if(t.left==null&&t.right==null){
            if(sum==target){alreadyFind=true;}
            return;
        }
        if(t.left!=null){DFS(t.left,sum+t.left.val);}
        if(t.right!=null){DFS(t.right,sum+t.right.val);}
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
