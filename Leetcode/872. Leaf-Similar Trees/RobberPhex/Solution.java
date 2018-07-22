import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<TreeNode> list1 = new LinkedList<>();
    private int indexOfList1 = 0;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfsWithSave(root1, list1);
        return dfs(root2);
    }

    public boolean dfs(TreeNode node) {
        if (node.left != null) {
            if (!dfs(node.left))
                return false;
        }
        if (node.right != null) {
            if (!dfs(node.right))
                return false;
        }
        if (node.left == null && node.right == null) {
            if (node.val != list1.get(indexOfList1).val)
                return false;
            indexOfList1++;
            return true;
        }
        return true;
    }

    public void dfsWithSave(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            dfsWithSave(node.left, list);
        }
        if (node.right != null) {
            dfsWithSave(node.right, list);
        }
        if (node.left == null && node.right == null) {
            list.add(node);
        }
    }

    public static void main(String[] args) {
        boolean res = new Solution().leafSimilar(null, null);
        System.out.println(res);
    }
}
