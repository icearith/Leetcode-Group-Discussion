class Solution {
    public int binaryGap(int N) {
        int ans = 0, last = -1;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }
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
