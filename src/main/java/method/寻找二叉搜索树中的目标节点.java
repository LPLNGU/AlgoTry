package method;

/**
 * <p>leetcode LCR174</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-11-28 20:52
 */
public class 寻找二叉搜索树中的目标节点 {


    public static void main(String[] args) {

    }


    int res = 0;
    int index = 0;

    public int findTargetNode(TreeNode root, int cnt) {
        traverseMid(root, cnt);
        return res;
    }


    public void traverseMid(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }
        traverseMid(root.right, cnt);
        if (++index == cnt) {
            res = root.val;
        }
        traverseMid(root.left, cnt);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
