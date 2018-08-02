import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int newResult = twoSum(nums, i + 1, target - nums[i]) + nums[i];
            if (Math.abs(newResult - target) < Math.abs(result - target))
                result = newResult;
        }
        return result;
    }

    public int twoSum(int[] nums, int startIndex, int target) {
        int lo = startIndex, hi = nums.length - 1;
        int ret = Integer.MAX_VALUE/2;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (Math.abs(sum - target) < Math.abs(ret - target))
                ret = sum;
            if (sum > target) {
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;

        res = solution.threeSumClosest(new int[]{1,1,1,1}, 0);
        System.out.println(res);
    }
}
