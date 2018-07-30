class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int curLen = 0;
        cur = head;
        while (cur != null) {
            if (curLen >= len / 2)
                break;
            cur = cur.next;
            curLen++;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head;
        ListNode tmp=null;

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

        tmp = new Solution().middleNode(new ListNode(1));
        System.out.println(tmp.val);
    }
}
