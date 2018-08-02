import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] digitMap = new char[][]{
                new char[]{},
                new char[]{},
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'},
        };

        List<String> prev = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            if (prev.isEmpty())
                prev.add("");
            for (String str : prev) {
                for (char c : digitMap[digits.charAt(i) - '0']) {
                    cur.add(str + c);
                }
            }
            List<String> tmp = prev;
            prev = cur;
            cur = tmp;
            cur.clear();
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res;

        res = solution.letterCombinations("23");
        for (String word : res)
            System.out.println(word);
    }
}
