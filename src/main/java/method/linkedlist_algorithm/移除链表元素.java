package method.linkedlist_algorithm;

/**
 * <p>203</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-09-28 14:17
 */
public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sen = new ListNode(-1);
        sen.next = head;
        ListNode node = sen;
        while (node.next != null) {
            if (node.next.val == val) {
                if (node.next.next == null) {
                    node.next = null;
                    break;
                } else {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        return sen.next;
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
