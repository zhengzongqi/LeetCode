package 数据结构系列.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class T173 {

    class BSTIterator {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        public BSTIterator(TreeNode root) {
            reverse(root);
        }

        public void reverse(TreeNode t){
            if(t==null){
                return;
            }
            reverse(t.left);
            queue.offer(t);
            reverse(t.right);
        }

        public int next() {
            return queue.poll().val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
