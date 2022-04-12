package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 25
 * @author: 李沛隆21081020
 * @create: 2022-04-08 10:37
 */
public class K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //迭代记得判空
        if (head == null) {
            return null;
        }
        //每次走k步
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        //反转k个元素
        ListNode newHead = reverseToNode(head, cur);
        //把反转后的尾节点接到后续反转的头节点上
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    public ListNode reverseToNode(ListNode head, ListNode end) {
        ListNode current = head, pre = null, next = null;
        while (current != end) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;

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
