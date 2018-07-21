class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = 0, n2 = 0;
        int i1 = 0, i2 = 0;
        while (i1 < version1.length() || i2 < version2.length()) {
            n1 = 0;
            n2 = 0;
            while (i1 < version1.length() && version1.charAt(i1) != '.') {
                n1 *= 10;
                n1 += (version1.charAt(i1) - '0');
                i1++;
            }
            if (i1 < version1.length() && version1.charAt(i1) == '.')
                i1++;
            while (i2 < version2.length() && version2.charAt(i2) != '.') {
                n2 *= 10;
                n2 += (version2.charAt(i2) - '0');
                i2++;
            }
            if (i2 < version2.length() && version2.charAt(i2) == '.')
                i2++;
            if (n1 < n2)
                return -1;
            else if (n2 < n1)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("0.1", "1.1"));
        System.out.println(solution.compareVersion("1.0.1", "1"));
        System.out.println(solution.compareVersion("1.0", "1"));
        System.out.println(solution.compareVersion("7.5.2.4", "7.5.3"));
    }
}
