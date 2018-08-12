import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] << 1 == target) {
                if (half < 0) {
                    half = i;
                } else {
                    return new int[]{half, i};
                }
            } else {
                int complement = target - nums[i];
                Integer index = map.get(complement);
                if (index != null) {
                    return new int[]{index, i};
                }
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
