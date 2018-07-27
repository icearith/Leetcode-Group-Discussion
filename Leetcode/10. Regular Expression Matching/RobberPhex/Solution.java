class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int indexS, int indexP) {
        while (indexP < p.length()) {
            if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
                // 处理带星号的情况
                for (; indexS < s.length(); indexS++) {
                    if (isMatch(s, p, indexS, indexP + 2)) {
                        return true;
                    } else if (p.charAt(indexP) != '.' && p.charAt(indexP) != s.charAt(indexS)) {
                        return false;
                    }
                }
                indexP += 2;
            } else if (p.charAt(indexP) != '.' && (indexS >= s.length() || s.charAt(indexS) != p.charAt(indexP))) {
                return false;
            } else {
                if (indexS >= s.length())
                    return false;
                indexP++;
                indexS++;
            }
        }
        if (indexS < s.length() || indexP < p.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;

        res = solution.isMatch("a", ".*..a*");
        System.out.println(res);
    }
}
