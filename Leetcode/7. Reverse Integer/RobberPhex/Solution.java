class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            x = -x;
            sign = -1;
        }
        long r = 0;
        while (x > 0) {
            r *= 10;
            r += x % 10;
            x /= 10;
        }
        if (r > Integer.MAX_VALUE)
            return 0;
        return (int) (r * sign);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(123 + "\t" + solution.reverse(123));
        System.out.println(-123 + "\t" + solution.reverse(-123));
        System.out.println(120 + "\t" + solution.reverse(120));
        System.out.println(1534236469 + "\t" + solution.reverse(1534236469));
    }
}
