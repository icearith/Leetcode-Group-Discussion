class Solution {
    public int mirrorReflection(int p, int q) {
        int pl = p;
        int ql = q;
        while (true) {
            if (ql % p == 0) {
                if ((pl / p) % 2 == 1) {
                    if ((ql / p) % 2 == 1) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 2;
                }
            }
            pl += p;
            ql += q;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().mirrorReflection(3, 1);
        System.out.println(res);
    }
}
