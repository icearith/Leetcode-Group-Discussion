import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums.length <= 1)
            return nums;

        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < res.length; i++) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                int tmp = res[j];
                res[j] = nums[i];
                res[i] = tmp;
            } else {
                res[i] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        int[] param_1 = obj.shuffle();
        int[] param_2 = obj.reset();
        int[] param_3 = obj.shuffle();
        System.out.println(1);
    }
}