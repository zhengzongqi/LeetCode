package 其他;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T382 {


    class Solution {
        int len;
        List<Integer> list = new ArrayList<Integer>();
        Random r;
        public Solution(ListNode head) {
            list.clear();
            while(head!=null){
                list.add(head.val);
                head=head.next;
            }
            len = list.size();
            r = new Random(len);
        }

        public int getRandom() {
            return list.get(r.nextInt(len));
        }
    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
