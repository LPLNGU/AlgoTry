package method.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: suanfati
 * @description: 226翻转二叉树
 * @author: 李沛隆21081020
 * @create: 2022-03-08 11:19
 */
public class 翻转二叉树 {
    //解法1：层序遍历，依次修改节点左右引用
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmp = node.right;
                node.right = node.left;
                node.left = tmp;
            }
        }
        return root;
    }

    //解法2：递归前序遍历，非常easy
    public TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree02(root.left);
        invertTree02(root.right);
        return root;
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
