import java.util.Arrays;

class Solution {
    private static int[][] counts = new int[31][];

    {
        int cur = 1;
        for (int i = 0; i < counts.length; i++) {
            counts[i] = count(cur);
            cur *= 2;
        }
    }

    public boolean reorderedPowerOf2(int N) {
        int[] countOfN = count(N);
        for (int i = 0; i < counts.length; i++)
            if (Arrays.equals(countOfN, counts[i]))
                return true;
        return false;
    }

    public int[] count(int N) {
        int[] count = new int[10];
        while (N > 0) {
            count[N % 10]++;
            N /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reorderedPowerOf2(1));
        System.out.println(solution.reorderedPowerOf2(10));
        System.out.println(solution.reorderedPowerOf2(16));
        System.out.println(solution.reorderedPowerOf2(24));
        System.out.println(solution.reorderedPowerOf2(46));
        System.out.println(solution.reorderedPowerOf2(218));
    }
}
