package method.linkedlist_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-31 11:32
 */
public class 合并k个有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1.val - o2.val
        );
        ListNode resultNode = new ListNode(-1);
        ListNode iterateNode = resultNode;

        for (ListNode node : lists) {
            if (node != null) {
                nodePriorityQueue.add(node);
            }
        }
        while (!nodePriorityQueue.isEmpty()) {
            ListNode node = nodePriorityQueue.remove();
            iterateNode.next = node;
            if (node.next != null) {
                nodePriorityQueue.add(node.next);
            }
            iterateNode = iterateNode.next;
        }
        return resultNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
