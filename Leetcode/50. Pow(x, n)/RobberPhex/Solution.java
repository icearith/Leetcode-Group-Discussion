class Solution {
    public double myPow(double x, int n) {
        long pn = n;
        int sign = x < 0 ? -1 : 1;
        double ans = 1;
        if (pn < 0)
            pn = -pn;
        if (sign < 0) {
            x = -x;
            sign = pn % 2 != 0 ? -1 : 1;
        }

        while (pn-- > 0) {
            ans = ans * x;
            if (Double.isInfinite(ans))
                return 0;
            if (ans >= 0 && ans <= Double.MIN_VALUE)
                return 0;
            if (ans - 1 <= Double.MIN_VALUE && 1 - ans <= Double.MIN_VALUE)
                break;
        }
        if (n < 0)
            ans = 1 / ans;
        return ans * sign;
    }

    public static void main(String[] args) {
        double res;
        res = new Solution().myPow(2, -2147483648);
        System.out.println(res);
    }
}
