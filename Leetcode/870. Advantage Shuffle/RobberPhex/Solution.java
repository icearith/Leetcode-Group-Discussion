import java.util.*;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        Map<Integer, Deque<Integer>> assgined = new HashMap<>();
        for (int b : B)
            assgined.put(b, new LinkedList<>());

        Deque<Integer> remaining = new LinkedList<>();
        int iB = 0;
        for (int a : sortedA) {
            if (a > sortedB[iB]) {
                assgined.get(sortedB[iB]).add(a);
                iB++;
            } else {
                remaining.add(a);
            }
        }

        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            if (assgined.get(B[i]).isEmpty()) {
                ans[i] = remaining.pop();
            } else {
                ans[i] = assgined.get(B[i]).pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res;
        res = solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
        for (int n : res) {
            System.out.println(n);
        }
    }
}
