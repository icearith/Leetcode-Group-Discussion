class Solution {
    public int mySqrt(int x) {
        long min = -1, max = 1L + x;
        while (min < max - 1) {
            long mid = ((long) min + max + 1) / 2;
            //System.out.println(mid);
            if (mid * mid <= x) {
                min = (int) mid;
            } else {
                max = (int) mid;
            }
        }
        return (int) min;
    }

    public static void main(String[] args) {
        int res;
        Solution solution = new Solution();

        res = solution.mySqrt(2147395599);
        System.out.println(res);
    }
}
