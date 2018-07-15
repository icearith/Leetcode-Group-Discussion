class Solution {
    public int binaryGap(int N) {
        int ans = 0, cur = 0;
        boolean in = false;
        while (N > 0) {
            if (in) {
                if (N % 2 == 0) {
                    cur++;
                } else {
                    ans = Math.max(ans, cur + 1);
                    in = false;
                }
            }
            if (N % 2 == 1) {
                cur = 0;
                in = true;
            }
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
        System.out.println(solution.binaryGap(5));
        System.out.println(solution.binaryGap(6));
        System.out.println(solution.binaryGap(8));
    }
}
