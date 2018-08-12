import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> res = new LinkedList<>();
    public TreeNode target = null;
    public int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.target = target;
        this.K = K;

        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return -1;
        if (root.val == target.val) {
            add(root, K);
            return 0;
        }

        int dis = dfs(root.left);
        if (dis != -1) {
            if (dis + 1 == K)
                res.add(root.val);
            else
                add(root.right, K - dis - 2);
            return dis + 1;
        }

        dis = dfs(root.right);
        if (dis != -1) {
            if (dis + 1 == K)
                res.add(root.val);
            else
                add(root.left, K - dis - 2);
            return dis + 1;
        }
        return -1;
    }

    public void add(TreeNode root, int dis) {
        if (root == null)
            return;
        if (dis == 0) {
            res.add(root.val);
        } else if (dis > 0) {
            add(root.left, dis - 1);
            add(root.right, dis - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode left, right, parent;
        left = new TreeNode(7);
        right = new TreeNode(4);
        parent = new TreeNode(2);
        parent.left = left;
        parent.right = right;

        left = new TreeNode(6);
        right = parent;
        parent = new TreeNode(5);
        parent.left = left;
        parent.right = right;

        left = new TreeNode(0);
        right = new TreeNode(8);
        {
            TreeNode tmp = new TreeNode(1);
            tmp.left = left;
            tmp.right = right;
            right = tmp;
        }
        left = parent;
        parent = new TreeNode(3);

        parent.left = left;
        parent.right = right;


        List<Integer> res = new Solution().distanceK(parent, new TreeNode(5), 2);
        for (int r : res) {
            System.out.print(r);
            System.out.print(',');
        }
        System.out.println();
    }
}
