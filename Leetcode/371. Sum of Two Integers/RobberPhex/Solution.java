class Solution {
    public int getSum(int a, int b) {
        int bit = 1, res = 0, carry = 0;
        while (true) {
            int ba = a & bit;
            int bb = b & bit;
            res = carry ^ ba ^ bb | res;

            carry = (carry & ba) | (carry & bb) | (ba & bb);
            if (bit < 0)
                break;
            bit <<= 1;
            carry = carry == 0 ? 0 : bit;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().getSum(-12, -8);
        System.out.println(res);
    }
}
