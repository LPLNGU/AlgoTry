package method.tree;

import java.util.*;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-03 09:21
 */
public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recursion(node.left, res);
        res.add(node.val);
        recursion(node.right, res);
        return;
    }

    //正常使用中序遍历的迭代法
    public List<Integer> iterateInorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            //先走到最左侧
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                //此刻已经走到空，拿出栈中的节点，使其进入结果集，然后进入右节点重复操作。
                node = stack.poll();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    //针对三种遍历都可以的通用迭代写法，使用null当作标记值
    public List<Integer> iterateInorderPro(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (node == null) {
            return res;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.poll();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.poll();
                node = stack.poll();
                res.add(node.val);
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
