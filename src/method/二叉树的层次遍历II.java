package method;import java.util.*;/** * <p> * * </p> * * @author lipeilong * @time 2020/9/6 22:50 * @description */public class 二叉树的层次遍历II {    public List<List<Integer>> levelOrderBottom(TreeNode root) {        LinkedList<List<Integer>> result = new LinkedList<>();        if (root == null) {            return result;        }        Queue<TreeNode> queue = new LinkedList<>();        queue.add(root);        while (!queue.isEmpty()) {            List<Integer> oneLevel = new ArrayList<>();            int count = queue.size();            for (int i = 0; i < count; i++) {                TreeNode node = queue.poll();                oneLevel.add(node.val);                if (node.left != null) {                    queue.add(node.left);                }                if (node.right != null) {                    queue.add(node.right);                }            }            result.addFirst(oneLevel);        }        return result;    }    public class TreeNode {        int val;        TreeNode left;        TreeNode right;        TreeNode(int x) {            val = x;        }    }}