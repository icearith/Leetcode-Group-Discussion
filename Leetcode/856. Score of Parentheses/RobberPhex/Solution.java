class Solution {
    public int scoreOfParentheses(String S) {
        int openPos[] = new int[S.length() * 2];
        int sum[] = new int[S.length() * 2];

        int curLevel = 0;
        for (int cur = 0; cur < S.length(); cur++) {
            if (S.charAt(cur) == '(') {
                curLevel += 1;
                openPos[curLevel] = cur;
                sum[curLevel]=0;
            } else {
                if (openPos[curLevel] + 1 == cur) {
                    sum[curLevel - 1] += 1;
                } else {
                    sum[curLevel - 1] += sum[curLevel] * 2;
                }
                curLevel -= 1;
            }
        }
        return sum[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;
        res = solution.scoreOfParentheses("()");
        assert res == 1;
        res = solution.scoreOfParentheses("(())");
        assert res == 2;
        res = solution.scoreOfParentheses("()()");
        assert res == 2;
        res = solution.scoreOfParentheses("(()(()))");
        assert res == 6;
        res = solution.scoreOfParentheses("(())(())");
        assert res == 4;
    }
}
