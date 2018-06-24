class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        int firstDiffPos = -1, secondDiffPos = -1;
        int stat[] = new int[300];
        boolean two = false;
        for (int i = 0; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (stat[A.charAt(i)] >= 2) {
                two = true;
            }
            if (A.charAt(i) != B.charAt(i)) {
                firstDiffPos = i;
                break;
            }
        }
        if (firstDiffPos == -1)
            return two;
        for (int i = firstDiffPos + 1; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (A.charAt(i) != B.charAt(i)) {
                secondDiffPos = i;
                break;
            }
        }
        if (secondDiffPos == -1)
            return false;
        if (A.charAt(firstDiffPos) != B.charAt(secondDiffPos) || A.charAt(secondDiffPos) != B.charAt(firstDiffPos))
            return false;
        for (int i = secondDiffPos + 1; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (A.charAt(i) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().buddyStrings("", "");
    }
}
