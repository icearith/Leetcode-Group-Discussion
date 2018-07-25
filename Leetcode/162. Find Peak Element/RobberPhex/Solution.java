class Solution {
    public int findPeakElement(int[] A) {
        for (int i = 0; i < A.length - 1; i++)
            if (A[i] > A[i + 1])
                return i;
        return A.length - 1;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().findPeakElement(new int[]{2, 1});
        System.out.println(res);
    }
}
