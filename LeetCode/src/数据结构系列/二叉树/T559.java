package 数据结构系列.二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T559 {
    @Test
    public void test(){
        Node t = new Node();
        t.children = new ArrayList<>();
        t.children.add(new Node(1,new ArrayList<>()));

        System.out.println(maxDepth(t));
    }
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int res = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size()!=0){
            res++;
            Queue<Node> temp_queue = new LinkedList<Node>();
            while(queue.size()!=0){
                Node n = queue.poll();
                for(Node nn : n.children){
                    temp_queue.offer(nn);
                }
            }
            queue = temp_queue;
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
