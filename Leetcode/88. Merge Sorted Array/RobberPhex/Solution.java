class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            index2--;
            index--;
        }
        while (index1 >= 0) {
            if (index == index1)
                break;
            nums1[index] = nums1[index1];
            index1--;
            index--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;

        solution.merge(num1, m, new int[]{2, 5, 6}, n);

        for (int i = 0; i < m + n; i++) {
            System.out.print(num1[i]);
            System.out.print(",");
        }
        System.out.println();
    }
}
