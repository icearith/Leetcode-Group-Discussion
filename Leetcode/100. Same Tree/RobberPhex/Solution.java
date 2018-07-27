class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        if (!isSameTree(p.left, q.left))
            return false;
        if (!isSameTree(p.right, q.right))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;
        TreeNode t1, t2;

        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);


        res = solution.isSameTree(t1, t2);
        System.out.println(res);
    }
}
