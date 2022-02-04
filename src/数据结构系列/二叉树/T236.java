package 数据结构系列.二叉树;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T236 {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t6.left=t2;
        t6.right=t7;
        t2.left=t1;
        t2.right=t4;
        t4.left = t3;
        t4.right = t5;
        t7.left = t8;

        lowestCommonAncestor(t6,t3,t5);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        queue = new LinkedList<>();
        search(root,p,q);
        return queue.poll();
    }
    //用一个队列来存储含有pq的所有子树的根节点，最先进来的就是最近的祖先，队列里面的元素从后到先为根节点到最近祖先的路径
    Deque<TreeNode> queue;
    //以root为根的树含有p和q的数量
    public int search(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        if(root ==p||root==q){
            int count = 1+search(root.left,p,q)+search(root.right,p,q);
            if(count==2){
                queue.offer(root);
            }
            return count;
        }
        else{
            int count = search(root.left,p,q)+search(root.right,p,q);
            if(count==2){
                queue.offer(root);
            }
            return count;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {  }
    TreeNode(int x) { val = x; }
}
