import java.util.HashMap;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> mapping = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode prev = new RandomListNode(0);
        RandomListNode newHead = prev;
        for (RandomListNode cur = head; cur != null; cur = cur.next) {
            RandomListNode tmp = new RandomListNode(cur.label);
            prev.next = tmp;
            prev = tmp;
            mapping.put(cur, tmp);
        }
        newHead = newHead.next;

        for (RandomListNode cur = head, newCur = newHead; cur != null; cur = cur.next, newCur = newCur.next) {
            newCur.random=mapping.get(cur.random);
        }

        return newHead;
    }
}
