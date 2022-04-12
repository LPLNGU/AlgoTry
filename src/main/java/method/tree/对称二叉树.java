package method.tree;

import java.util.*;

/**
 * @program: suanfati
 * @description: 101对称二叉树
 * @author: 李沛隆21081020
 * @create: 2022-03-09 19:21
 */
public class 对称二叉树 {

    //解法1，类似中序遍历，内外节点依次对比，使用递归写法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean outsideCompare = compare(left.left, right.right);
        boolean insideCompare = compare(left.right, right.left);
        return outsideCompare && insideCompare;
    }

    //解法2，使用迭代写法，主要使用了二叉树的层序遍历
    public boolean isSymmetric02(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean res;
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            //每次判定两个节点
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            //双空，此时对称
            if (left == null && right == null) {
                continue;
            }
            //如果判定失败直接返回false
            if (left == null || right == null || (right.val != left.val)) {
                return false;
            }
            //两个if都没有判定成功，这种状况下继续判定后续的节点，两两一组判定，但是需要注意顺序！
            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
