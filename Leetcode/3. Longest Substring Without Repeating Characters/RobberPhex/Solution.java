class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] stats = new int[128];
        int longest = 0;
        int start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (stats[s.charAt(end)] <= 0) {
                stats[s.charAt(end)]++;
                end++;
                longest = Math.max(longest, end - start);
            } else {
                stats[s.charAt(start)]--;
                start++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("abcabcbb:\t" + solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:\t" + solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew\t" + solution.lengthOfLongestSubstring("pwwkew"));
    }
}
