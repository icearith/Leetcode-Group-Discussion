class Solution {
    public int scoreOfParentheses(String S) {
        int sum = 0;

        int curLevel = 0;
        for (int cur = 0; cur < S.length(); cur++) {
            if (S.charAt(cur) == '(') {
                curLevel += 1;
            } else {
                curLevel -= 1;
                if (S.charAt(cur - 1) == '(')
                    sum += 1 << curLevel;
            }
        }
        return sum;
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
