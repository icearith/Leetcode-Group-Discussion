import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] intList) {
        val = intList[0];
        ListNode cur = this;
        for (int i = 1; i < intList.length; i++) {
            cur.next = new ListNode(intList[i]);
            cur = cur.next;
        }
    }
}