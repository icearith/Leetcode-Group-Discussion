class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;

        res = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }
}
