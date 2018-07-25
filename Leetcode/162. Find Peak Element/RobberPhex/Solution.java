class Solution {
    public int findPeakElement(int[] A) {
        for (int i = 0; i < A.length; i++)
            if ((i < 1 || A[i - 1] < A[i]) && (i + 1 >= A.length || A[i] > A[i + 1]))
                return i;
        return 0;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(res);
        res = new Solution().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        System.out.println(res);
    }
}
