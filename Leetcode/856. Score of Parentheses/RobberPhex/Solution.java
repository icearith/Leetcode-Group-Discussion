class Solution {
    public int scoreOfParentheses(String S) {
        return scoreOfParentheses(S, 0, S.length() - 1);
    }

    public int scoreOfParentheses(String S, int start, int end) {
        int depth = 0;
        int res = 0;
        for (int cur = start; cur <= end; cur++) {
            if (S.charAt(cur) == '(') {
                depth += 1;
            } else {
                if (S.charAt(cur) == ')') {
                    depth -= 1;
                    if (depth == 0) {
                        if (cur - start == 1) {
                            res += 1;
                        } else {
                            res += 2 * scoreOfParentheses(S, start + 1, cur - 1);
                        }
                        start = cur + 1;
                    }
                }
            }
        }
        return res;
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
    }
}
