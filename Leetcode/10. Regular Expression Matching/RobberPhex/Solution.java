enum Result {
    TRUE, FALSE
}

class Solution {
    private Result[][] results;

    public boolean isMatch(String s, String p) {
        results = new Result[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int indexS, int indexP) {
        if (results[indexS][indexP] != null) {
            return results[indexS][indexP] == Result.TRUE;
        }
        while (indexP < p.length()) {
            if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
                // 处理带星号的情况
                for (; indexS < s.length(); indexS++) {
                    if (isMatch(s, p, indexS, indexP + 2)) {
                        results[indexS][indexP + 2] = Result.TRUE;
                        return true;
                    } else if (p.charAt(indexP) != '.' && p.charAt(indexP) != s.charAt(indexS)) {
                        results[indexS][indexP] = Result.FALSE;
                        return false;
                    }
                    results[indexS][indexP] = Result.FALSE;
                }
                results[indexS][indexP] = Result.TRUE;
                indexP += 2;
                results[indexS][indexP] = Result.TRUE;
            } else if (p.charAt(indexP) != '.' && (indexS >= s.length() || s.charAt(indexS) != p.charAt(indexP))) {
                results[indexS][indexP] = Result.FALSE;
                return false;
            } else {
                if (indexS >= s.length()) {
                    results[indexS][indexP] = Result.FALSE;
                    return false;
                }
                indexP++;
                indexS++;
            }
        }
        if (indexS < s.length()) {
            results[indexS][indexP] = Result.FALSE;
            return false;
        }
        results[indexS][indexP] = Result.TRUE;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;

        res = solution.isMatch("a", ".*..a*");
        System.out.println(res);
    }
}
