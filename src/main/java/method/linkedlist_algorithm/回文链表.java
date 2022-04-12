package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 234
 * @author: 李沛隆21081020
 * @create: 2022-04-08 11:25
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    ListNode left;

    public boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = traverse(head.next);
        res = res && (head.val == left.val);
        left = left.next;
        return res;
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
