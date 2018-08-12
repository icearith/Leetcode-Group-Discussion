class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int len = 0;
        int i = n;
        i++;
        while (i-- > 0 && fast != null) {
            len++;
            fast = fast.next;
        }
        while (fast != null) {
            len++;
            fast = fast.next;
            slow = slow.next;
        }
        if (len == n)
            return head.next;
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head, node;
        ListNode res;

        head = new ListNode(2);
        node = head;
        head = new ListNode(1);
        head.next = node;
        res = solution.removeNthFromEnd(head, 1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
