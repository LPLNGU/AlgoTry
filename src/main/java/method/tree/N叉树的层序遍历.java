package method.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>层序遍历</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-06 10:29
 */
public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                rowList.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(rowList);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
