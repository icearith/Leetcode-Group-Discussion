class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long nn = n;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }

        double factor = x;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= factor;
            }
            nn /= 2;
            factor *= factor;
        }
        return ans;
    }

    public static void main(String[] args) {
        double res;
        res = new Solution().myPow(2, 10);
        System.out.println(res);
    }
}
