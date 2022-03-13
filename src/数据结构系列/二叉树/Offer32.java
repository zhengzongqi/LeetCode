package 数据结构系列.二叉树;

import java.util.*;

public class Offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){return res;}
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            level++;
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> queue_temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                temp.add(t.val);
                if(t.left!=null){queue_temp.offer(t.left);}
                if(t.right!=null){queue_temp.offer(t.right);}
            }
            if(level%2==0){
                Collections.reverse(temp);
            }
            res.add(temp);
            queue = queue_temp;
        }
        return res;
    }
}
