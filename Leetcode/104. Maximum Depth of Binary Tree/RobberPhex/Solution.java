class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res;
        TreeNode tree;

        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);


        res = solution.maxDepth(tree);
        System.out.println(res);
    }
}
