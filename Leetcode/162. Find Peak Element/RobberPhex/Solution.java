class Solution {
    public int findPeakElement(int[] A) {
        int min = 0, max = A.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (A[mid] > A[mid + 1])
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().findPeakElement(new int[]{2, 1});
        System.out.println(res);
    }
}
