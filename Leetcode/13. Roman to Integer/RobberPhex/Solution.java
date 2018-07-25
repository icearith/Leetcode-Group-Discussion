class Solution {
    static public int[] map = new int[128];

    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    public int romanToInt(String s) {
        int cur = 0;
        int ans = 0;
        while (cur < s.length()) {
            if (cur + 1 < s.length() && map[s.charAt(cur)] < map[s.charAt(cur + 1)]) {
                ans += (map[s.charAt(cur + 1)] - map[s.charAt(cur)]);
                cur += 2;
            } else {
                ans += map[s.charAt(cur)];
                cur++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().romanToInt("III");
        System.out.println(res);
        res = new Solution().romanToInt("IV");
        System.out.println(res);
        res = new Solution().romanToInt("IX");
        System.out.println(res);
        res = new Solution().romanToInt("LVIII");
        System.out.println(res);
        res = new Solution().romanToInt("MCMXCIV");
        System.out.println(res);
    }
}
