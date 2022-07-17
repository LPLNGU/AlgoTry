package method.tree;

/**
 * <p>BM29 二叉树中和为某一值的路径(一)</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-09 17:46
 */
public class 二叉树中和为某一值的路径 {

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        int currentNum = sum - node.val;
        if (currentNum == 0 && node.left == null && node.right == null) {
            return true;
        }
        return dfs(node.left, currentNum) || dfs(node.right, currentNum);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
