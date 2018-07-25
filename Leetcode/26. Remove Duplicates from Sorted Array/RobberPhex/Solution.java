class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                if (index != i) {
                    nums[index] = nums[i];
                }
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int res;
        int[] arg;

        arg = new int[]{1, 1, 2};
        res = new Solution().removeDuplicates(arg);

        for (int i = 0; i < res; i++)
            System.out.println(arg[i]);
        System.out.println("-------");

        arg = new int[]{1, 1, 2, 2};
        res = new Solution().removeDuplicates(arg);

        for (int i = 0; i < res; i++)
            System.out.println(arg[i]);
        System.out.println("-------");
    }
}
