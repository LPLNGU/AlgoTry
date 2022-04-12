package method.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: suanfati
 * @description: 559
 * @author: 李沛隆21081020
 * @create: 2022-03-14 15:36
 */
public class N叉树的最大深度 {
    //递归
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)), max);
        }
        return max + 1;
    }

    //层序，迭代
    public int maxDepth01(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                for (int j = 0; j < root.children.size(); j++) {
                    queue.add(root.children.get(j));
                }
            }
            depth++;
        }
        return depth;
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
}
