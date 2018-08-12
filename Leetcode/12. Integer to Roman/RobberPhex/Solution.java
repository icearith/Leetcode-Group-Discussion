class Solution {
    public String intToRoman(int num) {
        int[] digits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1,};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I",};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            while (num >= digits[i]) {
                sb.append(strs[i]);
                num -= digits[i];
            }
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
