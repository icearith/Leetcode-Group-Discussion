class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0, max = nums.length;
        while (min < max) {
            int mid = (min + max) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int res;

        res = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(res);

        res = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(res);

        res = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(res);

        res = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(res);
    }
}
