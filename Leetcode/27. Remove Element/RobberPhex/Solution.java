class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cur = 0;
        while (cur < n) {
            if (nums[cur] == val) {
                nums[cur] = nums[n - 1];
                n--;
            } else {
                cur++;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int res;
        int[] arg;

        arg = new int[]{3, 2, 2, 3};
        res = new Solution().removeElement(arg, 3);

        for (int i = 0; i < res; i++)
            System.out.println(arg[i]);
        System.out.println("-------");

        arg = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        res = new Solution().removeElement(arg, 2);

        for (int i = 0; i < res; i++)
            System.out.println(arg[i]);
        System.out.println("-------");
    }
}
