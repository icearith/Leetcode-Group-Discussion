import java.util.stream.IntStream;

public class Solution {
    public int minMoves(int[] nums) {
        return IntStream.of(nums).sum() - IntStream.of(nums).min().getAsInt() * nums.length;
    }
}