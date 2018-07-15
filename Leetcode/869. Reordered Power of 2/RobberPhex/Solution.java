class Solution {
    public boolean reorderedPowerOf2(int N) {
        String s = Integer.toString(N);
        int[] A = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            A[i] = s.charAt(i) - '0';
        return permutations(A, 0);
    }

    public boolean permutations(int[] A, int start) {
        if (start >= A.length)
            return isPowerOf2(A);
        for (int i = start; i < A.length; i++) {
            int tmp;

            tmp = A[i];
            A[i] = A[start];
            A[start] = tmp;

            if (permutations(A, start + 1))
                return true;

            tmp = A[i];
            A[i] = A[start];
            A[start] = tmp;
        }
        return false;
    }

    public boolean isPowerOf2(int[] A) {
        if (A[0] == 0)
            return false;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans *= 10;
            ans += A[i];
        }
        return ((ans - 1) & ans) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reorderedPowerOf2(1));
        System.out.println(solution.reorderedPowerOf2(10));
        System.out.println(solution.reorderedPowerOf2(16));
        System.out.println(solution.reorderedPowerOf2(24));
        System.out.println(solution.reorderedPowerOf2(46));
        System.out.println(solution.reorderedPowerOf2(218));
    }
}
