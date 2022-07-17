package method.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>剑指offer 33</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-20 16:09
 */
public class 二叉树的后序遍历 {
    //反转写法，根右左
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderRes = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                postorderRes.add(root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode pop = stack.pop();
            root = pop.left;
        }
        postorderRes
    }*/

    public List<Integer> postorderTraversal01(TreeNode root) {
        List<Integer> postorderRes = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = new TreeNode(0);
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || pre == root.right) {
                postorderRes.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root.right);
                root = root.right;
            }
        }
        return postorderRes;
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
