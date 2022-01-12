package 数据结构系列;

public class T207 {

    public boolean isPalindrome(ListNode head) {
        left = head;
        return travelse(head);
    }

    ListNode left ;
    //判断从node节点到链表尾的这一段链表（假设长度为i）与链表开始的i个节点是否能构成回文
    public boolean travelse(ListNode node){
        if(node == null){
            return true;
        }
        boolean res = travelse(node.next);
        if(node.val!=left.val){
            res = false;
        }
        left = left.next;
        return res;
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
