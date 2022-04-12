package method.tree;

/**
 * @program: suanfati
 * @description: 110.平衡二叉树
 * @author: 李沛隆21081020
 * @create: 2022-03-22 17:54
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        boolean res = false;
        if (!(recursionIsBalanced(root) == -1)) {
            res = true;
        }
        return res;
    }

    public Integer recursionIsBalanced(TreeNode root) {
        //终止条件就是如果碰到节点为空，那么高度就算空
        if (root == null) {
            return 0;
        }
        Integer leftHeight = recursionIsBalanced(root.left);
        //此处操作相当于把某个子树不符合高度要求的return到最终的树
        if (leftHeight == -1) {
            return -1;
        }
        Integer rightHeight = recursionIsBalanced(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        //两个子树本身符合了高度要求，后面判定当前子树是否符合要求
        int height;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            height = -1;
        } else {
            height = Math.max(leftHeight, rightHeight) + 1;
        }
        return height;
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
