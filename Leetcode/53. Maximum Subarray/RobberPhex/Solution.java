class Solution {
    public int maxSubArray(int[] nums) {
        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                ans = (int) Math.max(sums[j] - sums[i], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res;
        Solution solution = new Solution();

        res = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(res);
    }
}
