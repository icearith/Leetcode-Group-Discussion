class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int cnt = len / k;
        int large = len % k;

        ListNode[] ret = new ListNode[k];
        ListNode[] last = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; i++) {
            int curCnt = cnt;
            if (i < large)
                curCnt++;
            for (int j = 0; j < curCnt; j++) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
                if (ret[i] == null) {
                    ret[i] = tmp;
                    last[i] = tmp;
                } else {
                    last[i].next = tmp;
                    last[i] = tmp;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
    }
}