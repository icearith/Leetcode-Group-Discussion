import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<TreeNode> queue = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
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
