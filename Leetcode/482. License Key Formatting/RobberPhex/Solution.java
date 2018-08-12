class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean add = false;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            } else if (!Character.isDigit(c) && !Character.isUpperCase(c)) {
                continue;
            }
            cnt++;
            if (add) {
                sb.append('-');
                add = false;
            }
            sb.append(c);
            if (cnt % K == 0 && i != 0) {
                add = true;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4);
        System.out.println(res);
        res = new Solution().licenseKeyFormatting("2-5g-3-J", 2);
        System.out.println(res);
        res = new Solution().licenseKeyFormatting("--a-a-a-a--", 2);
        System.out.println(res);
    }
}
