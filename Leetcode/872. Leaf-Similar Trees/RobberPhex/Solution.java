import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        TreeLeafIterator iterator1 = new TreeLeafIterator(root1);
        TreeLeafIterator iterator2 = new TreeLeafIterator(root2);

        while (true) {
            try {
                if (iterator1.next().val != iterator2.next().val) {
                    return false;
                }
            } catch (NoSuchElementException e) {
                try {
                    iterator2.next();
                } catch (NoSuchElementException ee) {
                }
                return !iterator1.hasNext() && !iterator2.hasNext();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head;

//        head = new TreeNode(3);
//        head.left = new TreeNode(5);
//        head.left.left = new TreeNode(6);
//        head.left.right = new TreeNode(2);
//        head.left.right.left = new TreeNode(7);
//        head.left.right.right = new TreeNode(4);
//        head.right = new TreeNode(1);
//        head.right.left = new TreeNode(9);
//        head.right.right = new TreeNode(8);

        head = new TreeNode(119);
        head.left = new TreeNode(113);
        head.left.left = new TreeNode(11);
        head.left.left.left = new TreeNode(43);
        head.left.left.left.left = new TreeNode(67);
        head.left.left.left.right = new TreeNode(74);
        head.left.left.right = new TreeNode(76);
        head.left.right = new TreeNode(30);
        head.left.right.left = new TreeNode(15);
        head.left.right.right = new TreeNode(60);

        TreeLeafIterator iter = new TreeLeafIterator(head);
        while (iter.hasNext()) {
            try {
                TreeNode next = iter.next();
                System.out.println(next.val);
            } catch (NoSuchElementException e) {
            }
        }
    }
}

class TreeLeafIterator implements Iterator<TreeNode> {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode last;
    private boolean hasNext = true;

    TreeLeafIterator(TreeNode tree) {
        stack.push(tree);
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public TreeNode next() {
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            boolean lVisited = false, rVisited = false;
            if (last != null && node.right != null && last == node.right) {
                lVisited = true;
                rVisited = true;
            } else if (last == node.left) {
                lVisited = true;
            }
            lVisited = node.left == null || lVisited;
            rVisited = node.right == null || rVisited;
            last = node;
            if (lVisited && rVisited) {
                stack.pop();
                if (node.left == null && node.right == null) {
                    return node;
                }
            } else if (node.left != null && !lVisited) {
                last = node.left;
                if (node.left.left == null && node.left.right == null)
                    return node.left;
                else
                    stack.push(node.left);
            } else if (node.right != null && !rVisited) {
                last = node.right;
                if (node.right.left == null && node.right.right == null)
                    return node.right;
                else
                    stack.push(node.right);
            }
        }
        hasNext = false;
        throw new NoSuchElementException();
    }
}