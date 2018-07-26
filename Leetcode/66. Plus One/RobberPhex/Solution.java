class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            carry = digits[i] >= 10 ? 1 : 0;
            digits[i] %= 10;
            if (carry == 0)
                break;
        }
        if (carry == 0)
            return digits;
        int[] ans = new int[digits.length + 1];
        ans[0] = carry;
        for (int i = 0; i < digits.length; i++)
            ans[i + 1] = digits[i];
        return ans;
    }

    public static void main(String[] args) {
        int[] res;
        Solution solution = new Solution();

        res = solution.plusOne(new int[]{9, 9, 9});
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i]);
        System.out.println();
    }
}
