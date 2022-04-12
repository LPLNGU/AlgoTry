package method.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @program: suanfati
 * @description: 111
 * @author: 李沛隆21081020
 * @create: 2022-03-14 19:31
 */
public class 二叉树的最小深度 {
    //递归算法，后续遍历，排除左空右不空以及右空左不空的情况
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    //迭代写法，后序遍历
//    public int minDepth01(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//
//        }
//    }

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
