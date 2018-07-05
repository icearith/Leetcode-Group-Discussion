class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int start = 0;
        int i;
        for (i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                int end = i - 1;
                if (start != end) {
                    profit += (prices[end] - prices[start]);
                }
                start = i;
            }
        }
        int end = i - 1;
        if (start != end) {
            profit += (prices[end] - prices[start]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int res = new Solution().maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(res);
    }
}
