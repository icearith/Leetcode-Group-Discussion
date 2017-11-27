class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                k %= i;
                i = -1;
                cur = head;
            } else
                cur = cur.next;
        }
        ListNode new_head = head;
        if (cur == null)
            return head;
        while (cur.next != null) {
            cur = cur.next;
            new_head = new_head.next;
        }
        cur.next = head;
        head = new_head.next;
        new_head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1), head = cur;
        for (int i = 2; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head = new Solution().rotateRight(head, 3);
        System.out.println(head.val);
    }
}