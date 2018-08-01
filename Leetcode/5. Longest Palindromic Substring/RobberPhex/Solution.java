class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.MAX_VALUE);
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));
            sb.append(Character.MAX_VALUE);
        }
        int[] p = new int[sb.length()];
        int id = 0, mx = 0;
        int sIndex = 0, eIndex = 0;
        for (int i = 0; i < sb.length(); i++) {
            p[i] = mx > i ? Math.min(mx - i, p[id * 2 - i]) : 1;
            while (i + p[i] < sb.length() && i - p[i] >= 0 && sb.charAt(i + p[i]) == sb.charAt(i - p[i]))
                p[i]++;
            if (p[i] > eIndex - sIndex) {
                if (i % 2 == 0) {
                    // 一定在左面
                    sIndex = i / 2 - (p[i] - 1) / 2;
                } else {
                    sIndex = i / 2 - (p[i] - 1) / 2;
                }
                eIndex = sIndex + p[i] - 1;
            }
            if (i + p[i] > mx) {
                id = i;
                mx = i + p[i];
            }
        }

        return s.substring(sIndex, eIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestPalindrome("");
        System.out.println(res);
    }
}
