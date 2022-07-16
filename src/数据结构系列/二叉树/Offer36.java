package 数据结构系列.二叉树;

import org.junit.Test;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class Offer36 {

    @Test
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n4.left = n3;
        n4.right = n5;

        treeToDoublyList(n4);
    }

    List<Node> list;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        if(root.left==null&&root.right==null){
            root.left = root;
            root.right = root;
            return root;
        }
        list = new ArrayList<>();
        reverse(root);
        for(int i = 0;i<list.size();i++){
            if(i==0){
                list.get(i).right = list.get(i+1);
                list.get(i).left = list.get(list.size()-1);
            }
            else if(i==list.size()-1){
                list.get(i).right = list.get(0);
                list.get(i).left = list.get(i-1);
            }
            else{
                list.get(i).right = list.get(i+1);
                list.get(i).left = list.get(i-1);
            }
        }
        return list.get(0);
    }

    public void reverse(Node root){
        if(root==null){
            return;
        }
        reverse(root.left);
        list.add(root);
        reverse(root.right);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
