package method.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: suanfati
 * @description: 104.二叉树的最大深度
 * @author: 李沛隆21081020
 * @create: 2022-03-14 15:19
 */
public class 二叉树的最大深度 {
    @Test
    public void test(){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(maxDepth(node));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        TreeNode node = root;
        int count = 0;
        while (!stack.isEmpty() && node != null) {
            while (node.right != null) {
                node = node.right;
                stack.add(node);
            }
            if (node.left == null) {
                count = Math.max(stack.size(), count);
                node = stack.pop();
            } else {
                node = node.left;
            }
        }
        return count;
    }

    //递归法
    public int maxDepth01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
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
