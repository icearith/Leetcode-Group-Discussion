class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode cur = head;
        ListNode tail1 = null;
        ListNode head1 = head;
        int curIndex = 1;
        while (curIndex < m) {
            tail1 = cur;
            cur = cur.next;
            curIndex++;
        }

        ListNode tail2 = cur;
        ListNode prev = tail1;
        while (curIndex <= n) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            curIndex++;
        }

        tail2.next = cur;
        if (tail1 == null) {
            if (prev == null) {
                return head;
            } else {
                return prev;
            }
        } else {
            tail1.next = prev;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(3);
        cur = cur.next = new ListNode(4);
        cur = cur.next = new ListNode(5);
        cur.next = null;

        cur = new Solution().reverseBetween(head, 2, 4);
        System.out.println(cur);
    }
}