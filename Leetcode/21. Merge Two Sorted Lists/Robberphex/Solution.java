class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmpHead = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, cur = tmpHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }
        return tmpHead.next;
    }
}