class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, min = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int res;
        Solution solution = new Solution();

        res = solution.maxSubArray(new int[]{-1});
        System.out.println(res);
    }
}
