class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int l1 = 0, l2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (l1 < nums1.length && (l2 >= nums2.length || nums1[l1] < nums2[l2])) {
                merged[i] = nums1[l1];
                l1++;
            } else {
                merged[i] = nums2[l2];
                l2++;
            }
        }
        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2] + merged[(merged.length - 1) / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
