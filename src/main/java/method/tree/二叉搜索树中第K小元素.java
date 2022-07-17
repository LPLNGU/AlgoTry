package method.tree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>leetcode 230</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-20 11:31
 */
public class 二叉搜索树中第K小元素 {
    @Test
    public void test() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        System.out.println(kthSmallest(node, 1));
    }

    /**
     * 迭代解法
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            //此处走到最左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //操作
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            //遍历右节点
            root = root.right;
        }
        assert root != null;
        return root.val;
    }

    int result;
    int num;

    /**
     * 递归解法
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest01(TreeNode root, int k) {
        this.num = k;
        inorder(root);
        return result;
    }


    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        num--;
        if (num == 0) {
            result = node.val;
            return;
        }
        inorder(node.right);
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
