class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int sIndex = s.length(); sIndex >= 0; sIndex--) {
            for (int pIndex = p.length() - 1; pIndex >= 0; pIndex--) {
                boolean first_match = sIndex < s.length() &&
                        (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
                if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                    dp[sIndex][pIndex] = dp[sIndex][pIndex + 2] || first_match && dp[sIndex + 1][pIndex];
                } else {
                    dp[sIndex][pIndex] = first_match && dp[sIndex + 1][pIndex + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;

        res = solution.isMatch("a", ".*..a*");
        System.out.println(res);
    }
}
