package 数据结构系列;

import org.junit.Test;

import java.util.List;

public class 面试题02_04 {

    @Test
    public void test(){
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(2);
        ListNode t5 = new ListNode(5);
        ListNode t6 = new ListNode(2);
        System.out.println(t1.val);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        partition(t1,3);
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode h = new ListNode(101);
        h.next = head;
        ListNode reverse = head;
        while(reverse.next!=null){
            if(reverse.next.val<x){
                ListNode node = new ListNode(reverse.next.val);
                node.next = h.next;
                h.next=node;
                reverse.next=reverse.next.next;
            }
            else{
                reverse = reverse.next;
            }


            if(reverse == null){
                break;
            }
        }
        return h.next;

    }

      public class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
          }
      }
}
