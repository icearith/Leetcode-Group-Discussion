import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<TreeNode> list1 = new LinkedList<>();
    private List<TreeNode> list2 = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, list1);
        dfs(root2, list2);

        if (list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val != list2.get(i).val)
                return false;
        }
        return true;
    }

    public void dfs(TreeNode node, List<TreeNode> list) {
        // 如果当前是叶子节点
        if (node.left != null) {
            dfs(node.left, list);
        }
        if (node.right != null) {
            dfs(node.right, list);
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
