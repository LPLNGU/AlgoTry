package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 876
 * @author: 李沛隆21081020
 * @create: 2022-03-31 16:05
 */
public class 链表的中间节点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,
                slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
