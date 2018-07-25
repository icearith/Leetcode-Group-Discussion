class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
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
