import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> q = new LinkedList<>();
        int[] P = new int[A.length + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++)
            P[i + 1] = P[i] + A[i];

        for (int y = 0; y < P.length; y++) {
            while (!q.isEmpty() && P[q.getLast()] >= P[y])
                q.removeLast();
            while (!q.isEmpty() && P[q.getFirst()] + K <= P[y])
                ans = Math.min(ans, y - q.removeFirst());
            q.addLast(y);
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.shortestSubarray(new int[]{1}, 1));
        System.out.println(solution.shortestSubarray(new int[]{1, 2}, 4));
        System.out.println(solution.shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}
