class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int carry = 0;

        ListNode head=new ListNode(0);
        ListNode curr = head;
        while (head1 != null && head2 != null) {
            int newNum = head1.val + head2.val + carry;
            if (newNum >= 10)
                carry = 1;
            else
                carry = 0;
            ListNode tmp = new ListNode(newNum % 10);
            curr.next = tmp;
            curr = tmp;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head2 != null)
            head1 = head2;
        while (head1 != null) {
            int newNum = head1.val + carry;
            if (newNum >= 10)
                carry = 1;
            else
                carry = 0;
            ListNode tmp = new ListNode(newNum % 10);
            curr.next = tmp;
            curr = tmp;
            head1 = head1.next;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            curr.next = tmp;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode cur = head1;

        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(1);
        cur.next = null;

        ListNode head2 = new ListNode(1);

        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(9);
        cur = cur.next = new ListNode(1);
        cur.next = null;

        ListNode res = new Solution().addTwoNumbers(head1, head2);
        System.out.println(res);
    }
}
