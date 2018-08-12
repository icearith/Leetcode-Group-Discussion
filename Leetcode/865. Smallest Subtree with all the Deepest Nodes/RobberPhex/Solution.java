class Solution {
    public TreeNode res = null;
    public int max = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        max = dfs(root, 1);
        return res;
    }

    public int dfs(TreeNode root, int curDepth) {
        if (root == null)
            return 0;
        if (curDepth > max)
            max = curDepth;
        int rd = dfs(root.left, curDepth + 1);
        int ld = dfs(root.right, curDepth + 1);
        if (rd == ld && rd + curDepth >= max) {
            res = root;
        }

        return Math.max(rd, ld) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode left = new TreeNode(7), right = new TreeNode(4);
        TreeNode parent = new TreeNode(2);

        parent.left = left;
        parent.right = right;

        right = parent;

        left = new TreeNode(6);
        parent = new TreeNode(5);
        parent.left = left;
        parent.right = right;
        left = parent;
        {
            TreeNode tmpleft = new TreeNode(0);
            TreeNode tmpright = new TreeNode(8);
            right = new TreeNode(1);
            right.left = tmpleft;
            right.right = tmpright;
        }
        parent = new TreeNode(3);
        parent.left = left;
        parent.right = right;
        parent = solution.subtreeWithAllDeepest(parent);
        System.out.println(parent.val);
    }
}
