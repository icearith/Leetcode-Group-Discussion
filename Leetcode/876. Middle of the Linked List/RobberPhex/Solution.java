class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head;
        ListNode tmp = null;

        head = new ListNode(6);
        tmp = head;
        head = new ListNode(5);
        head.next = tmp;
        tmp = head;
        head = new ListNode(4);
        head.next = tmp;
        tmp = head;
        head = new ListNode(3);
        head.next = tmp;
        tmp = head;
        head = new ListNode(2);
        head.next = tmp;
        tmp = head;
        head = new ListNode(1);
        head.next = tmp;

        tmp = new Solution().middleNode(head);
        System.out.println(tmp.val);
    }
}
