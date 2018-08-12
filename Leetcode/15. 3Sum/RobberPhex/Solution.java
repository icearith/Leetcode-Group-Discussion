import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            twoSum(nums, i + 1, -nums[i], ans);
        }
        return ans;
    }

    private void twoSum(int[] nums, int startIndex, int target, List<List<Integer>> ans) {
        int low = startIndex, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                ans.add(Arrays.asList(-target, nums[low], nums[high]));
                low++;
                high--;
                while (low < high && nums[low] == nums[low - 1])
                    low++;
                while (low < high && nums[high] == nums[high + 1])
                    high--;
            } else if (nums[low] + nums[high] > target) {
                high--;
            } else {
                low++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res;
        res = solution.threeSum(new int[]{-2, 0, 0, 2, 2});
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
