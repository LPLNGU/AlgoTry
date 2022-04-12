package method.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: suanfati
 * @description: 257
 * @author: 李沛隆21081020
 * @create: 2022-03-25 10:45
 */
public class 二叉树的所有路径 {
    //回溯
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraversal(root, route, result);
        return result;
    }

    public void inorderTraversal(TreeNode node, List<Integer> route, List<String> result) {
        //添加到路径中
        route.add(node.val);
        //终止条件，碰到了叶子节点，把当前的route整理好格式后放到result中
        if (node.left == null && node.right == null) {
            StringBuilder currentRoute = new StringBuilder();
            for (int i = 0; i < route.size() - 1; i++) {
                currentRoute.append(route.get(i));
                currentRoute.append("->");
            }
            currentRoute.append(route.get(route.size() - 1));
            result.add(currentRoute.toString());
            return;
        }
        //进入没有终止条件
        //检索左节点，走入左节点后将其在route中移除（回溯）
        if (node.left != null) {
            inorderTraversal(node.left, route, result);
            route.remove(route.size() - 1);
        }
        //与上相反
        if (node.right != null) {
            inorderTraversal(node.right, route, result);
            route.remove(route.size() - 1);
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
