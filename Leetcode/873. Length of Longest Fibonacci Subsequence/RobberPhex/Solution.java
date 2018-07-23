import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int maxLength = 0;
        Set<Integer> numbers = new HashSet<>(A.length);
        for (int i = 0; i < A.length; i++)
            numbers.add(A[i]);

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int prev1 = A[i];
                int prev2 = A[j];
                int length = 2;
                while (numbers.contains(prev1 + prev2)) {
                    length++;
                    int tmp = prev1;
                    prev1 = prev2;
                    prev2 += tmp;
                }
                if (length > 2)
                    maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(res);
        res = new Solution().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18});
        System.out.println(res);
        res = new Solution().lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
        System.out.println(res);
    }
}
