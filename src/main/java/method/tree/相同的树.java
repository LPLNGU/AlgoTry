package method.tree;

/**
 * @program: suanfati
 * @description: 100
 * @author: 李沛隆21081020
 * @create: 2022-03-25 11:41
 */
public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);

    }

    public boolean traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        boolean compareResult = p.val == q.val;
        return compareResult && traverse(p.left, q.left) && traverse(p.right, q.right);
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
