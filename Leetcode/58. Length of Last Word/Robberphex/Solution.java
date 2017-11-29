class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        while (i >= 0 && chars[i] == ' ')
            i--;
        if (i < 0)
            return 0;
        int end = i;
        while (i >= 0) {
            if (chars[i] == ' ')
                break;
            i--;
        }
        return end - i;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int ret = obj.lengthOfLastWord("");
        System.out.println(ret);
    }
}