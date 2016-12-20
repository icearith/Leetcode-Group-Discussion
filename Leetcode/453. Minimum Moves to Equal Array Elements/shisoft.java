import java.util.stream.IntStream;

public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, n);
        }
        return sum - min * nums.length;
    }
}