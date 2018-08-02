import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new LinkedList<>();
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)
                    continue;
                twoSum(nums, results, j + 1, target, new Integer[]{nums[i], nums[j], 0, 0});
            }
        }
        return results;
    }

    public void twoSum(int[] nums, List<List<Integer>> results, int start, int target, Integer[] pResult) {
        int end = nums.length - 1;
        while (start < end) {
            int sum = pResult[0] + pResult[1] + nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                pResult[2] = nums[start];
                pResult[3] = nums[end];
                results.add(Arrays.asList(pResult.clone()));
                start++;
                while (start < end && nums[start] == nums[start - 1])
                    start++;
                end--;
                while (start < end && nums[end] == nums[end + 1])
                    end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res;

        res = solution.fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7);
        for (List<Integer> list : res) {
            for (int num : list)
                System.out.print(num + ", ");
            System.out.println();
        }
    }
}
