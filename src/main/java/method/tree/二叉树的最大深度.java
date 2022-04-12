package method.tree;

/**
 * @program: suanfati
 * @description: 104.二叉树的最大深度
 * @author: 李沛隆21081020
 * @create: 2022-03-14 15:19
 */
public class 二叉树的最大深度 {
    //递归法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }

    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
