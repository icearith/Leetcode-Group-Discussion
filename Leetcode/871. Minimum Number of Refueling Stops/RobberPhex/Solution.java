// LeetCode 871
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // dp[n]代表经过n次加油能达到的距离
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        // 此时dp的状态是没有加油站的状态
        for (int i = 0; i < stations.length; i++) {
            //让我们将第i个加油站加到其中
            //就必须更新dp
            for (int j = i; j >= 0; j--) {
                // 从i到0，由于都多了一个加油站，可能能达到的最远距离会变大
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        // 最后，找到到达target的，最小的i
        for (int i = 0; i < dp.length; i++)
            if (dp[i] >= target)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRefuelStops(1, 1, new int[0][0]));
        System.out.println(solution.minRefuelStops(100, 50, new int[][]{
                new int[]{25, 25},
                new int[]{50, 50},
        }));
        System.out.println(solution.minRefuelStops(100, 25, new int[][]{
                new int[]{25, 25},
                new int[]{50, 25},
                new int[]{75, 25},
        }));
    }
}
