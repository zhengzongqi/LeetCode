package 数据结构系列.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }

        queue.offer(root);
        while(queue.size()!=0){
            Queue<TreeNode> queue_temp = new LinkedList<TreeNode>();
            while(queue.size()!=0){
                TreeNode t = queue.poll();
                if(t.left!=null){
                    queue_temp.offer(t.left);
                }
                if(t.right!=null){
                    queue_temp.offer(t.right);
                }
                if(queue.size()==0){
                    res.add(t.val);
                }
            }
            queue = queue_temp;
        }

        return res;

    }
}
