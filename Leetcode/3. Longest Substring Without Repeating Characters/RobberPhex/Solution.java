class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int longest = 0;
        int start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            start = Math.max(start, index[s.charAt(end)]);
            if (index[s.charAt(end)] <= start) {
                index[s.charAt(end)] = end + 1;
                longest = Math.max(longest, end - start + 1);
            }
            end++;
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("abcabcbb:\t" + solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:\t" + solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew\t" + solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println("tmmzuxt:\t" + solution.lengthOfLongestSubstring("tmmzuxt"));
    }
}
