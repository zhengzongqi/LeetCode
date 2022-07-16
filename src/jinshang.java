
import org.junit.Test;

import java.util.*;

public class jinshang {

    @Test
    public void test(){

    }

    public void ques1(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> queue_temp = new LinkedList<>();

            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(temp.left!=null)queue_temp.offer(temp.left);
                if(temp.right!=null)queue_temp.offer(temp.right);
                System.out.println(temp.val);
            }
            System.out.println("\n");
            queue = queue_temp;
        }
    }




    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int a){
            val = a;
        }
    }
}
