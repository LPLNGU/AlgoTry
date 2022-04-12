package method.linkedlist_algorithm;

import org.junit.Test;

/**
 * @program: suanfati
 * @description: 19
 * @author: 李沛隆21081020
 * @create: 2022-03-31 14:17
 */
public class 删除链表的倒数第N个节点 {
    @Test
    public void test() {
        ListNode listNode = new ListNode(1),
                head = listNode;
        System.out.println(removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode toDel = findFromEnd(sentinel, n + 1);
        if (toDel.next != null) {
            ListNode tmp = toDel.next.next;
            toDel.next = tmp;
        }
        return sentinel.next;
    }

    public ListNode findFromEnd(ListNode head, int n) {
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            if (node != null) {
                node = node.next;
            }
        }
        while (node != null) {
            head = head.next;
            node = node.next;
        }
        return head;
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
