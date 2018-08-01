class Solution {
    private int indexL = 0, indexR = 1;

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            longestPalindrome(s, i, i + 1);
            longestPalindrome(s, i - 1, i + 1);
        }
        return s.substring(indexL, indexR);
    }

    private void longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if (r - l + 1 > indexR - indexL) {
            indexL = l;
            indexR = r + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestPalindrome("bb");
        System.out.println(res);
    }
}
