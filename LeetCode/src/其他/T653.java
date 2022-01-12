package 其他;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
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

public class T653 {
    @Test
    public void test(){}


    public boolean findTarget(TreeNode root, int k) {
        need = new HashSet<>();
        return travelse(root,k);
    }
    Set<Integer> need;

    public boolean travelse(TreeNode t,int k){
        if(t==null){
            return false;
        }
        if(need.contains(t.val)){
            return true;
        }
        else{
            need.add(k-t.val);
            return travelse(t.left,k)||travelse(t.right,k);
        }
    }
}
