package 其他.字符串;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

public class T138 {

}
    public Node copyRandomList(Node head) {
        return linkorCreate(head);
    }
    Map<Node,Node> map = new HashMap<Node,Node>();

    public Node linkorCreate(Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        else{
            Node n = new Node(node.val);
            map.put(node,n);
            n.next = linkorCreate(node.next);
            n.random = linkorCreate(node.random);
            return n;
        }
    }
}
