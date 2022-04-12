package method.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-02 16:38
 */
public class 前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    //递归
    public void recursion(TreeNode node, List<Integer> array) {
        if (node == null) {
            return;
        }
        array.add(node.val);
        recursion(node.left, array);
        recursion(node.right, array);
        return;
    }

    //迭代
    public List<Integer> iterate(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        if (node == null) {
            return res;
        }
        stack.push(node);
        TreeNode tmp = null;
        while (!stack.isEmpty()) {
            tmp = stack.poll();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
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
