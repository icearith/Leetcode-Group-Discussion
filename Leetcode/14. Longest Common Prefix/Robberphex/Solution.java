class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int curIndex = -1;
        while (true) {
            curIndex++;
            boolean good = true;
            String str1 = strs[0];
            for (String str : strs) {
                if (curIndex >= str.length() || str.charAt(curIndex) != str1.charAt(curIndex)) {
                    good = false;
                    break;
                }
            }
            if (good)
                sb.append(str1.charAt(curIndex));
            else
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ret = new Solution().longestCommonPrefix(new String[]{"a"});
        System.out.println(ret);
    }
}