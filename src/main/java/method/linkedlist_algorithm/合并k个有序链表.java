package method.linkedlist_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: suanfati
 * @description: 牛客BM5 合并k个已排序的链表
 * @author: 李沛隆21081020
 * @create: 2022-03-31 11:32
 */
public class 合并k个有序链表 {
    //二刷牛客的题目
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });
        for (ListNode node : lists) {
            if (node != null){
                minHeap.add(node);
            }
        }
        ListNode sentinelNode = new ListNode(0);
        ListNode currentNode = sentinelNode;
        while (!minHeap.isEmpty()) {
            ListNode currentMinNode = minHeap.remove();
            currentNode.next = currentMinNode;
            currentNode = currentMinNode;
            //证明是最后一个列表，剪掉后面的部分
            if (minHeap.isEmpty()) {
                return sentinelNode.next;
            }
            if (currentMinNode.next != null) {
                minHeap.add(currentNode.next);
            }
        }
        return sentinelNode.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //小根堆
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
