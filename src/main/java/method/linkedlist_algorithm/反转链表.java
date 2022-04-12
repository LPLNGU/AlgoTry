package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 剑指offer24、leetcode206
 * @author: 李沛隆21081020
 * @create: 2022-04-01 11:48
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代写法
    public ListNode reverseList01(ListNode head) {
        ListNode node = head, prev = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;

            node = next;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
