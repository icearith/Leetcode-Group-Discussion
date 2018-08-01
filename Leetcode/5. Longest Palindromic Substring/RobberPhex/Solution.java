class Solution {
    public String longestPalindrome(String s) {
        MyString str = new MyString(s);
        int[] p = new int[str.length()];
        int id = 0, mx = 0;
        int sIndex = 0, eIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            p[i] = mx > i ? Math.min(mx - i, p[id * 2 - i]) : 1;
            while (i + p[i] < str.length() && i - p[i] >= 0 && str.charAt(i + p[i]) == str.charAt(i - p[i]))
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

class MyString {
    private String s;
    private int len;

    MyString(String s) {
        this.s = s;
        len = s.length() * 2 + 1;
    }

    public int length() {
        return len;
    }

    public char charAt(int index) {
        if ((index + 1) % 2 == 0)
            return s.charAt((index + 1) / 2 - 1);
        return Character.MAX_VALUE;
    }
}
