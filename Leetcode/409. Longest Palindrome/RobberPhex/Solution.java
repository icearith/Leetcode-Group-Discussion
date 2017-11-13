class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[59];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c & 0x3f]++;
        }
        boolean odd = false;
        int maxLength = 0;

        for (int c : count) {
            maxLength += (c & (~1));
            odd = odd || (c & 1) == 1;
        }
        maxLength += (odd ? 1 : 0);
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abccccdd";
        System.out.println(new Solution().longestPalindrome(input));
    }
}
