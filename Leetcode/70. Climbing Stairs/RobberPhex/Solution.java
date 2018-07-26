class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res;
        Solution solution = new Solution();

        for (int i = 1; i < 10; i++) {
            res = solution.climbStairs(i);
            System.out.println(i + "\t" + res);
        }
    }
}
