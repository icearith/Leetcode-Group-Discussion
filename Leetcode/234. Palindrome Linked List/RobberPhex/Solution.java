class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fprev = null;
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            second = second.next.next;
            ListNode tmp = first;
            first = tmp.next;
            tmp.next = fprev;
            fprev = tmp;
        }
        if (second != null) {
            second = first.next;
            first = fprev;
        } else {
            second = first;
            first = fprev;
        }
        boolean ret = true;
        while (first != null && second != null) {
            if (first.val != second.val) {
                ret = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(2);
        cur = cur.next = new ListNode(1);
        cur.next = null;

        boolean res = new Solution().isPalindrome(head);
        System.out.println(res);
    }
}