class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < longest)
                break;
            int tmp = lengthOfLongestSubstring(s, i);
            if (tmp > longest)
                longest = tmp;
        }
        return longest;
    }

    private int lengthOfLongestSubstring(String s, int start) {
        int[] stats = new int[128];
        for (int i = start; i < s.length(); i++) {
            if (stats[s.charAt(i)]++ > 0) {
                return i - start;
            }
        }
        return s.length()-start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("abcabcbb:\t" + solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:\t" + solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew\t" + solution.lengthOfLongestSubstring("pwwkew"));
    }
}
