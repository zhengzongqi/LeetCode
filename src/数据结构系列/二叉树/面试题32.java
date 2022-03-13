package 数据结构系列.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 面试题32 {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode t = queue.poll();
                res.add(t.val);
                if(t.left!=null){queue.offer(t.left);}
                if(t.right!=null){queue.offer(t.right);}
            }
        }
        int[] res_ = new int[res.size()];
        for(int i=0;i<res.size();i++){
            res_[i] = res.get(i);
        }
        return res_;
    }
}
