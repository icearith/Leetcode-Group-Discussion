class Solution {
    public int findCircleNum(int[][] M) {
        int[] set = new int[M.length];
        int ans = 0;
        for (int i = 0; i < M.length; i++) {
            if (set[i] == 0) {
                dfs(M, set, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] M, int[] set, int start) {
        set[start] = 1;
        for (int i = 0; i < M.length; i++) {
            if (M[start][i] != 0 && start != i && set[i] == 0) {
                dfs(M, set, i);
            }
        }
    }

    public static void main(String[] args) {
        int res;
        res = new Solution().findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1},
        });
        System.out.println(res);
        res = new Solution().findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 1},
                new int[]{0, 1, 1},
        });
        System.out.println(res);
    }
}
