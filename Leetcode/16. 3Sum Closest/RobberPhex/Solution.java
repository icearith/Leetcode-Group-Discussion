import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 1 && nums[i] == nums[i - 1])
                continue;
            int newResult = twoSum(nums, i + 1, target - nums[i]) + nums[i];
            if (Math.abs(newResult - target) < Math.abs(result - target))
                result = newResult;
            if (result == target)
                break;
        }
        return result;
    }

    public int twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        int ret = Integer.MAX_VALUE / 2;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (Math.abs(sum - target) < Math.abs(ret - target))
                ret = sum;
            if (sum > target) {
                end--;
                while (start < end && nums[end] == nums[end + 1])
                    end--;
            } else if (sum < target) {
                start++;
                while (start < end && nums[start] == nums[start - 1])
                    start++;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;

        res = solution.threeSumClosest(new int[]{1, 1, 1, 1}, 4);
        System.out.println(res);
    }
}
