package method.tree;

import java.util.LinkedList;

/**
 * <p>牛客Z54 二叉搜索树的第k个节点
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-13 19:54
 */
public class 二叉搜索树的第k个节点 {

    LinkedList<TreeNode> incList = new LinkedList<>();

    public int KthNode(TreeNode proot, int k) {
        // write code here
        TreeNode res = proot;
        midTra(proot);
        if (incList.isEmpty() || k > incList.size() || k == 0) {
            return -1;
        }
        for (int i = 0; i < k; i++) {
            res = incList.removeFirst();
        }
        System.out.println(incList);
        return res.val;
    }

    public void midTra(TreeNode node) {
        if (node == null) {
            return;
        }
        midTra(node.left);
        incList.add(node);
        midTra(node.right);
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
