package method.tree;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-22 14:17
 */
public class 完全二叉树的节点个数 {
    public int countNodes01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes01(root.left) + countNodes01(root.right) + 1;
    }

    /**
     * 如果左边高度和右边高度相等，那么这个树是满二叉树，直接使用2^n-1公式计算就可得出高度，如果左右不等，则计算这个节点的左右子节点，并在结果加入当前节点。
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0, rightHeight = 0;
        TreeNode leftNode = root.left,
                rightNode = root.right;
        while (leftNode != null) {
            leftHeight++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            rightHeight++;
            rightNode = rightNode.right;
        }
        if (leftHeight == rightHeight) {
            //注意使用括号，算术移位的优先级更低，需要先进行移位操作
            return (2 << leftHeight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
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
