package method.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>leetcode 538</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-24 19:17
 */
public class 把二叉搜索树转换为累加树 {
    @Test
    public void test() {

    }


    List<Integer> sumList = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        recursive(root);
        return root;
    }

    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive(node.right);
        if (sumList.isEmpty()) {
            sumList.add(node.val);
        } else {
            Integer lastSum = sumList.get(sumList.size() - 1);
            int sum = node.val + lastSum;
            node.val = sum;
            sumList.add(sum);
        }
        recursive(node.left);
    }

    public class ValueSum {
        int value;
        int sum;

        ValueSum(int value, int sum) {
            this.value = value;
            this.sum = sum;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
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
