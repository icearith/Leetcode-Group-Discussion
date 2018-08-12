public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && slow != null) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head, node;
        boolean res;

        head = new ListNode(2);
        node = head;
        head = new ListNode(1);
        head.next = node;
        res = solution.hasCycle(head);
        System.out.println(res);
    }
}
