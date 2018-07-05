class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int total = 0;
        for (int i = 0; i < A[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += A[j][i];
            }
            if (sum * 2 < A.length)
                sum = A.length - sum;
            total += (sum << (A[0].length - 1 - i));
        }
        return total;
    }


    public static void main(String[] args) {
        int res = new Solution().matrixScore(new int[][]{
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 1, 0},
                new int[]{1, 1, 0, 0},
        });
        System.out.println(res);
    }
}
