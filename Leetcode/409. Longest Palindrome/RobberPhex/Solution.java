class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        boolean odd = false;
        int maxLength = 0;
        for (int c : count) {
            maxLength += (c >> 1 << 1);
            if (!odd && (c & 1) == 1) {
                odd = true;
                maxLength += 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abccccdd";
        System.out.println(new Solution().longestPalindrome(input));
    }
}
