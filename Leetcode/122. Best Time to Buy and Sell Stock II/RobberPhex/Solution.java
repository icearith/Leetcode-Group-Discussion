class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int res = new Solution().maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(res);
    }
}
