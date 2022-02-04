package 数据结构系列.二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class T919 {

    @Test
    public void  test(){
        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//
//        t6.left=t2;
//        t6.right=t7;
//        t2.left=t1;
//        t2.right=t4;
//        t7.left = t8;
        CBTInserter cbt = new CBTInserter(t1);
        cbt.insert(2);
        cbt.insert(3);
        cbt.insert(4);
        System.out.println(1);
    }

    class CBTInserter {

        public Queue<TreeNode> queue1 = new LinkedList<>();
        public Queue<TreeNode> queue2 = new LinkedList<>();
        public TreeNode r ;

        public CBTInserter(TreeNode root) {

            r = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue1.offer(root);

            //当前层应该有的节点个数
            int cen = 1;
            while(true){
                Queue<TreeNode> queue_temp = new LinkedList<>();
                while(queue.size()!= 0 ){
                    TreeNode t = queue.poll();
                    int s = t.val;
                    if(t.left!=null){
                        queue_temp.offer(t.left);
                    }
                    if(t.right!=null){
                        queue_temp.offer(t.right);
                    }
                }
                cen = cen*2;
                if(queue_temp.size()!=cen&&queue_temp.size()!=0){
                    queue2 = new LinkedList<>(queue_temp);
                    break;
                }
                else if(queue_temp.size()==0){
                    queue2.clear();
                    break;
                }
                else{
                    queue = queue_temp;
                    queue1 = new LinkedList<>(queue_temp);
                }
            }
            while(true){
                TreeNode t = queue1.peek();
                if(t.left!=null&&t.right!=null){
                    queue1.poll();
                }
                else{
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode t = new TreeNode(v);
            TreeNode t_get = queue1.peek();
            if(t_get.left==null){
                t_get.left = t;
                queue2.offer(t);
                return t_get.val;
            }
            else {
                t_get.right = t;
                queue2.offer(t);
                queue1.poll();
                if(queue1.size()==0){
                    queue1 = new LinkedList<>(queue2);
                    queue2.clear();
                }
                return t_get.val;
            }
        }

        public TreeNode get_root() {
            return r;
        }
    }
}
