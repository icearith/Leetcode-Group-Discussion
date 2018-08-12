import java.util.Stack;

class Solution {

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;

        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(nums[i], min[i - 1]);

        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!st.empty() && st.peek() <= min[i])
                    st.pop();
                while (!st.empty() && st.peek() < nums[i])
                    return true;
                st.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{3, 5, 0, 3, 4}));
    }
}
