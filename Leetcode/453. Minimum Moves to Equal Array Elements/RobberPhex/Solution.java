class Solution {
    public int minMoves(int[] nums) {
        int mn = Integer.MAX_VALUE;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            mn = Math.min(mn, num);
        }
        return (int) (sum - mn * nums.length);
    }

    public static void main(String[] args) {
        int res = new Solution().minMoves(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
