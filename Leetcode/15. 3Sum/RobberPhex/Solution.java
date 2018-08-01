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
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int target = 0 - nums[i] - nums[j];
                int l = j + 1, h = nums.length - 1;
                while (l < h) {
                    int mid = (l + h) / 2;
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else if (nums[mid] == target) {
                        l = mid;
                        break;
                    } else {
                        h = mid - 1;
                    }
                }
                if (nums[l] == target) {
                    List<Integer> tuple = new LinkedList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(nums[l]);
                    ans.add(tuple);
                }
            }
        }
        return ans;
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
