class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        if (!isSymmetric(left.right, right.left))
            return false;
        if (!isSymmetric(left.left, right.right))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;
        TreeNode tree;

        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);


        res = solution.isSymmetric(tree);
        System.out.println(res);
    }
}
