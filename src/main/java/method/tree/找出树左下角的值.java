package method.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: suanfati
 * @description: 513
 * @author: 李沛隆21081020
 * @create: 2022-03-30 19:36
 */
public class 找出树左下角的值 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i == 0){
                    result = node.val;
                }
                if (node.left != null) {
                    queue.add(root.left);
                }
                if (node.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return result;
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
