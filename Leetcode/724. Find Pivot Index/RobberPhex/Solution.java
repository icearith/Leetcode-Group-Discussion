class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int cur : nums) {
            rightSum += cur;
        }
        int cur = 0;
        try {
            rightSum -= nums[cur];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
        while (rightSum != leftSum && cur < nums.length - 1) {
            leftSum += nums[cur];
            cur += 1;
            rightSum -= nums[cur];
        }
        if (rightSum != leftSum)
            return -1;
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, 0, 1, 1, 0};
        System.out.println(new Solution().pivotIndex(nums));
    }
}