public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        RandomListNode newHead = head.next;
        cur = head;
        while (cur != null) {
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            if (tmp.next != null)
                tmp.next = tmp.next.next;
            cur = cur.next;
        }

        return newHead;
    }
}
