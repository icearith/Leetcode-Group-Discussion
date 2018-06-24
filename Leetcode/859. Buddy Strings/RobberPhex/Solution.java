class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return false;
        int f = -1, s = -1;
        int stat[] = new int[300];
        boolean two = false;
        for (int i = 0; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (stat[A.charAt(i)] >= 2) {
                two = true;
            }
            if (A.charAt(i) != B.charAt(i)) {
                f = i;
                break;
            }
        }
        if (f == -1)
            return two;
        for (int i = f + 1; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (A.charAt(i) != B.charAt(i)) {
                s = i;
                break;
            }
        }
        if (s == -1)
            return false;
        if (A.charAt(f) != B.charAt(s) || A.charAt(s) != B.charAt(f))
            return false;
        for (int i = s + 1; i < A.length(); i++) {
            stat[A.charAt(i)]++;
            if (A.charAt(i) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().buddyStrings("de", "ed");
    }
}
