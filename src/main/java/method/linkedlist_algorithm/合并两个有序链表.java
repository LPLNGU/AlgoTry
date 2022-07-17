package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: leetcode 21
 * @author: 李沛隆21081020
 * @create: 2022-04-28 15:37
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2,
                resListNode = new ListNode(-1),
                resHead = resListNode;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                resListNode.next = p2;
                p2 = p2.next;
            } else {
                resListNode.next = p1;
                p1 = p1.next;
            }
            resListNode = resListNode.next;
        }
        if (p1 != null) {
            resListNode.next = p1;
        }
        if (p2 != null) {
            resListNode.next = p2;
        }
        return resHead.next;
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
