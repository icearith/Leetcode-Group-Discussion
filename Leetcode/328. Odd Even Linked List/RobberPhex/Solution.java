public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddTail = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                oddTail = cur;
                cur = cur.next;
            } else {
                ListNode tmp = cur.next.next;
                if (cur.next.next != null)
                    cur.next.next = tmp.next;
                cur.next = tmp;
                oddTail = cur;
                cur = tmp;
            }
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
