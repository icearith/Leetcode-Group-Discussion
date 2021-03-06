class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(Math.min(height[l], height[r]) * (r - l), max);
            if (height[l] < height[r]) {
                int val = height[l];
                while (height[l] <= val && l < r)
                    l++;
            } else {
                int val = height[r];
                while (height[r] <= val && l < r)
                    r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;

        res = solution.maxArea(new int[]{1, 1});
        System.out.println(res);
    }
}
