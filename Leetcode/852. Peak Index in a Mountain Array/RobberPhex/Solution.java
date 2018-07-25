class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int min = 0, max = A.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (A[mid] < A[mid + 1]) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().peakIndexInMountainArray(new int[]{0, 1, 0});
        System.out.println(res);
        res = new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        System.out.println(res);
    }
}
