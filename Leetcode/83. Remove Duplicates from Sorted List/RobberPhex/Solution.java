class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode res;
        ListNode head, node;
        Solution solution = new Solution();

        node = new ListNode(2);
        head = new ListNode(1);
        head.next = node;
        node = head;
        head = new ListNode(1);
        head.next = node;

        res = solution.deleteDuplicates(head);
        node = res;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println();
    }
}
