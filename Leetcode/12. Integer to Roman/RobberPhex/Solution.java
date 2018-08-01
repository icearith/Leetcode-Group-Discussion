import java.util.HashMap;
import java.util.Map;

class Solution {
    private static int[] digits = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static String[] strs = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int high = digits.length - 1;
        while (num > 0) {
            int l = 0, r = high;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (digits[mid] <= num) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            high = l;
            sb.append(strs[l]);
            num -= digits[l];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res;
        res = solution.intToRoman(1994);
        System.out.println(res);
    }
}
