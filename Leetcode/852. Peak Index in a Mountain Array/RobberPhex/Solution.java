class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int indexOfMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[indexOfMax])
                indexOfMax = i;
        }
        return indexOfMax;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().peakIndexInMountainArray(new int[]{0, 1, 0});
        System.out.println(res);
        res = new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        System.out.println(res);
    }
}
