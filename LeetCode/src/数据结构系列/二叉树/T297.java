package 数据结构系列.二叉树;

import org.junit.Test;

import java.util.*;

public class T297 {
    @Test
    public void test(){
        Codec1 c = new Codec1();
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(7);

        System.out.println(c.serialize(t));
        TreeNode ss =  c.deserialize(c.serialize(t));
        System.out.println(t);
    }


    //层序遍历
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue = new LinkedList<TreeNode>();
            if(root == null){
                return null;
            }

            String res ="";
            queue.add(root);
            while(queue.size()!=0){
                TreeNode t = queue.poll();

                if(t==null){
                    res+="n ";
                    continue;
                }

                res+=String.valueOf(t.val)+" ";
                queue.offer(t.left);
                queue.offer(t.right);

            }
            return res;

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null){
                return null;
            }
            String[] datastr = data.split(" ");
            TreeNode root = new TreeNode(Integer.valueOf(datastr[0]));

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int idx = 1;
            while(queue.size()!=0){
                TreeNode t = queue.poll();
                if(datastr[idx].equals("n")){
                    t.left = null;
                }
                else{
                    TreeNode t1 = new TreeNode(Integer.valueOf(datastr[idx]));
                    t.left = t1;
                    queue.offer(t1);
                }
                idx++;
                if(datastr[idx].equals("n")){
                    t.right = null;
                }
                else{
                    TreeNode t1 = new TreeNode(Integer.valueOf(datastr[idx]));
                    t.right = t1;
                    queue.offer(t1);
                }
                idx++;

            }

            return root;
        }
    }
    //先序遍历
    public class Codec1 {

        public String serialize(TreeNode root) {

            return pretarvelse(root);

        }

        public String pretarvelse(TreeNode t){
            if(t==null){
                return "n ";
            }
            String s = String.valueOf(t.val)+ " ";
            return s+pretarvelse(t.left)+pretarvelse(t.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null){
                return null;
            }
            String[] datastr = data.split(" ");
            List<String> datastr_ = Arrays.asList(datastr);
            List<String> da = new ArrayList<>(datastr_);
            TreeNode t = pre_deserialize(da);
            return t;
        }

        public TreeNode pre_deserialize(List<String> datastr){
            if(datastr.size()==0){
                return null;
            }
            if(datastr.get(0).equals("n")){
                datastr.remove(0);
                return null;
            }
            TreeNode t = new TreeNode(Integer.valueOf(datastr.get(0)));
            datastr.remove(0);
            t.left = pre_deserialize(datastr);

            t.right = pre_deserialize(datastr);
            return t;
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

