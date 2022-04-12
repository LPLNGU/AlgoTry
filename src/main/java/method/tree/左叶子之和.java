package method.tree;

/**
 * @program: suanfati
 * @description: 404
 * @author: 李沛隆21081020
 * @create: 2022-03-28 13:50
 */
public class 左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftLeaves(root);
        return sum;
    }

    int sum = 0;

    public void sumLeftLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
        sumOfLeftLeaves(node.left);
        sumOfLeftLeaves(node.right);
        return;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
