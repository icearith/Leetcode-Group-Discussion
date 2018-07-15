import java.io.PrintStream;

class Solution {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.transpose(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        });
        solution.print(res, System.out);
        System.out.println("---end---");
        res = solution.transpose(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
        });
        solution.print(res, System.out);
        System.out.println("---end---");
    }

    public void print(int[][] A, PrintStream out) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                out.print(A[i][j]);
                out.print("\t");
            }
            out.println();
        }
    }
}
