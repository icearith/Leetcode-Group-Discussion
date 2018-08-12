class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int low = 0, high = nums2.length * 2;
        while (low <= high) {
            int mid2 = (low + high) / 2;
            int mid1 = nums1.length + nums2.length - mid2;

            int L1 = mid1 <= 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            int L2 = mid2 <= 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            int R1 = mid1 >= nums1.length * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
            int R2 = mid2 >= nums2.length * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
            // we need L1<R2 and L2<R1
            if (L1 > R2) {
                // we need mid2 to bigger
                low = mid2 + 1;
            } else if (L2 > R1) {
                high = mid2 - 1;
            } else {
                return (0.0 + Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double res = solution.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{3, 4}
        );
        System.out.println(res);
    }
}
