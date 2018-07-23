import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int maxLength = 0;
        Map<Integer, Integer> index = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++)
            index.put(A[i], i);

        HashMap<Integer, Integer> longest = new HashMap<>();
        for (int j = 0; j < A.length - 1; j++) {
            for (int k = j + 1; k < A.length; k++) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int curLength = longest.getOrDefault(i * A.length + j, 2) + 1;
                    longest.put(j * A.length + k, curLength);
                    maxLength = Math.max(maxLength, curLength);
                }
            }
        }
        if (maxLength > 2)
            return maxLength;
        return 0;
    }

    public static void main(String[] args) {
        int res;
        // 5
        res = new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(res);
        // 3
        res = new Solution().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18});
        System.out.println(res);
        // 5
        res = new Solution().lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
        System.out.println(res);
    }
}
