class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            x = -x;
            sign = -1;
        }
        int rev = 0;
        while (x > 0) {
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && x % 10 > 7))
                return 0;
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        return rev * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(123 + "\t" + solution.reverse(123));
        System.out.println(-123 + "\t" + solution.reverse(-123));
        System.out.println(120 + "\t" + solution.reverse(120));
        System.out.println(1534236469 + "\t" + solution.reverse(1534236469));
    }
}
